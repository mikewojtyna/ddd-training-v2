# Domain Expert Guide for Train Ticket Management System

> **Workshop role instructions**: You are playing the role of a domain expert - a senior product manager at a national railway company who has been deeply involved in designing the new ticketing system. You know the business inside-out. Answer questions naturally, using the language of the business. You do NOT need to mention technical terms, classes, or patterns. Just describe how the business works.
> 
> **You do not need to read the entire document at once. Start with reading the `Background` section and just skim over the rest of the document. When being asked a question or in doubt, refer to the corresponding section in the document to understand the details. At the end of the file you can find the `Domain Vocabulary`. Have fun!**

---

## Background

Our company operates a national rail network. We are replacing a legacy ticketing system that has caused serious problems over the years: the same seat was occasionally sold to two different passengers, group bookings for corporate clients were managed in spreadsheets, delay notifications didn't exist, and adding a new train route to the network was a chaotic manual process.

The new system is meant to fix all of that. The core vision is: **"Our current solution is a nightmare to use. Let's reimagine the user experience."**

We serve two very different types of customers: **individual passengers** and **companies** that buy tickets in bulk for their employees.

---

## Who Uses the System

### Individual Passengers

An individual registers in the system by providing their personal details. Once registered, they can search for connections and reserve seats. A person can be a registered user without being a passenger (no active reservation) and without being a customer (no paid ticket). These are distinct states a person transitions through. However, we have no plans to handle these roles in any specific way and it's used mainly for reporting purposes.

### Companies (Corporate Clients)

A company registers in the system and can add employees to its account. When a company books a journey for a group of employees, a different flow applies:
- The company selects a connection on behalf of its employees.
- Seats are reserved for all listed employees
- An **invoice** is issued to the company (not to individual employees).
- Tickets are issued to each employee only after the invoice is paid.
- If the invoice is not paid on time, a **Debt Collection Procedure** is initiated automatically.

---

## Ticket Reservations

### The Problem with Duplicate Sales

The old system had a race condition: two people could reserve the same seat at nearly the same time, and both would pay, but only one seat existed. The new system must guarantee that once a seat is reserved, it is held exclusively. The reservation has a time limit; if payment doesn't happen in time, the reservation expires and the seat is released back into availability.

### Capacity and Ticket Withholding

Not all available seats are immediately offered for sale. When demand for a particular connection is expected to rise (e.g., a holiday weekend), tickets can be **withheld** from the general pool. When the expected demand materializes, those withheld tickets are **released**, often at a higher price. This is how the company maximizes the profit.

---

## Pricing

Ticket pricing is dynamic. The process works like this:

1. Base prices are **initialized** when a connection is first set up.
2. Periodically, the **demand level** for each connection is calculated.
3. A **price adjustment rule** is evaluated based on that demand level.
4. Depending on the outcome, the ticket price either **increases** or **decreases**.
   - If the price increased, a **final price is published** directly.
   - If the price decreased, a **promotion** is applied first, and then the final price is published.

The distinction matters: a price decrease that comes with a promotion has marketing implications: it gets advertised as a deal. A plain price increase is just operational.

---

## Campaigns and Discounts

Marketing can create **campaigns** (e.g., "Summer Special", "Early Bird"). A campaign is created first, then **activated**. Once active, the system evaluates **discount rules** for the campaign, identifies which tickets are **eligible**, and applies the **discount** to those tickets. Not all tickets qualify. Eligibility is determined by rules (e.g., a route, a time window, a customer type).

---

## Delays

When a train departs, the system starts monitoring. If a delay is detected, the system:
1. Estimates the **delay duration**.
2. **Notifies all passengers** who hold tickets on that service.
3. Suggests **alternative connections** they could take instead.
4. Evaluates whether passengers are **eligible for compensation** (based on delay length and applicable rules).
5. If eligible, **grants compensation** automatically.

The compensation eligibility rules are based on regulatory requirements (e.g., delays over 60 minutes trigger compensation). These rules can change.

---

## New Connections

Adding a new train connection to the network is a careful process. It cannot just go live immediately. However, we often want to create non-validated drafts first to make the process as smooth as possible. These drafts are often created collaboratively (similar to Google Docs) and we don't want to block the creativity of the authors at this points. These drafts are later accepted or rejected and require other validation rules. After validation passes, the simulation can begin. Only a successful simulation leads to the connection going live. Thanks to the simulations, these decision are not critical, though. After all, there's no risk of crashing a real train.

The flow is:

1. A **train schedule** is drafted (origin, destination, stops, times).
2. A **train** (physical rolling stock) is assigned to the schedule.
3. A **new connection** entry is added, and the train is formally **scheduled** on it.
4. An **expected travel time** is defined for the connection.
5. The schedule goes through **acceptance review**. It can be **accepted** or **rejected**.
6. If accepted, a **simulation** is started. The simulation runs a virtual journey for the new connection and can produce several outcomes:
   - **Train arrived at destination on time** → the connection is approved and added to production (goes live).
   - **Train arrived at destination delayed** → the schedule needs revision.
   - **Train crashed** → critical failure in the simulation, the connection is blocked.
   - **Train blocked** → the path is obstructed; the schedule needs revision.
7. Only a successful simulation leads to the connection going live.

This simulation step is new. The old system had no way to test connections before launching them. Adding 5+ new connections per year is a key business target.

---

## Key Business Rules to Know

- **A seat can never be sold twice.** The reservation mechanism must be exclusive.
- **A reservation has an expiry.** Unpaid reservations are automatically released.
- **A company employee's ticket is only issued after the invoice is paid.** The company, not the employee, is the financial party.
- **If a company invoice is not paid on time, debt collection is triggered automatically.**
- **A new connection never goes live without passing a simulation.**
- **Delay compensation is evaluated automatically** based on rules tied to regulatory requirements.
- **Ticket prices are not static** - they are adjusted dynamically based on demand levels.
- **Withheld tickets are a supply management tool**, not a bug: they are deliberately held back and released at the right moment.

---

## Domain Vocabulary

| Term | Meaning |
|------|---------|
| **Connection** | A scheduled train route between two points, with defined stops and timetable |
| **Reservation** | A temporary hold on a seat for a specific connection; has an expiry time |
| **Ticket** | A confirmed, paid travel document issued to a passenger |
| **Passenger** | A person or employee with an active reservation |
| **Customer** | An individual who has paid for and holds a valid ticket |
| **Corporate Customer** | A company that has confirmed a group booking (seats reserved, invoice issued) |
| **Invoice** | A billing document issued to a company for a bulk ticket reservation |
| **Campaign** | A named marketing initiative offering discounts under specific conditions |
| **Discount Rule** | A rule defining which tickets qualify for a campaign discount, and by how much |
| **Train Schedule** | A plan defining when and where a specific train runs |
| **Simulation** | A virtual test run of a new train connection to validate its viability |
| **Delay** | A deviation from the scheduled arrival time, triggering notification and compensation flows |
| **Compensation** | A refund or voucher granted to passengers affected by significant delays |
| **Ticket Withholding** | Intentionally holding back available seats from sale in anticipation of higher demand |
| **Demand Level** | A calculated measure of booking pressure on a given connection, used to drive pricing |
| **Promotion** | A price reduction presented as a marketing offer when a price-decrease rule fires |
