# Supple design & policies

## Your task
Create a new model supporting the following requirements.

1. Project verifiers can decide if proposal can be accepted or rejected based on multiple factors:
    - Project description
    - Project goal
    - Loan schedule
    - Interest rate
    - Borrower's credit score
    - And possibly many more...
2. Investors can invest into assets using investment strategies
   1. Manual into project
   2. Manual into asset
   3. Automated preset strategy
   4. Automated custom strategy
3. Interests paid to investors can change dynamically over the lifetime of a project. For example, the interest rate can depend on the country of the borrower, the amount of money already raised, the number of investors, etc.

Consider using the Policy building block.

### Solution
You can find solutions in the `solutions.crowdsorcery.task5` package.

## Discussion
- When do you introduce policies?
- What are the differences between stable and dynamic logic?
- What are the benefits of introducing polciies?
- Are there any drawbacks of introducing policies?