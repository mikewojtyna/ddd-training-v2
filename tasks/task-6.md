# Reacting to fundraising status changes
We want to react on multiple status changes regarding project fundraising steps. Take a look at the [FundraisingService.java](..%2Fsrc%2Fmain%2Fjava%2Fpl%2Fwojtyna%2Ftrainings%2Frecipes%2Fproblems%2Ftask6%2Fservices%2FFundraisingService.java).

## Problems
Currently, we want to react by sending an email to the project owner, sending slack notifications and initiating the marketing process. However, we want to be able to react in different ways in the future. We want to be able to add new reactions without changing the `FundraisingService` class.

The current design definitely doesn't support that. The fundraising service acts a a god class delegating the work to multiple other services handling status changes. Each time new reaction is added, we need to change the `FundraisingService` class.

## Your task
Decouple FundraisingService from the reactions. The reactions should be able to subscribe to the fundraising status changes and react accordingly. The reactions should be able to subscribe to multiple status changes.

1. Model status changes as events.
2. Publish events from the `FundraisingService` class.
3. Handle mailing, slack notifications and marketing as event subscribers handling the interesting events.

There are following rules:
- Mail notification subscriber should react on any event
- Slack notification subscriber should react only on Project Accepted or Project Rejected event
- Marketing subscriber should react only on Project Fundraising Started event

### Solution
As always, you can find the solution in the `solutions.task6` package.

## Discussion
- Is it easier to add new reactions after using events to integrate vetween modules?
- What are the problems of Event Driven Architecture?
- When should we use Event Driven Architecture?