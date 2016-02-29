## Code Review Checklist

Please see the Code Review Checklist [HERE](https://liaison-intl.atlassian.net/wiki/display/TDD/Code+Review+Checklist).

#### Focus on Tests
*Ask to see the tests. If they are not present or incomplete, stop the review and reschedule it for a later time*
- [ ] Are they clear in describing the behaviors under test? 
- [ ] Do they follow naming conventions?
- [ ] Do unit tests isolate code units properly?
- [ ] Does test isolation (mocking, etc.) utilize expected frameworks and naming conventions?
- [ ] Do integration tests provide clarity on precisely what components they test integration of?
- [ ] Do tests provide acceptable coverage?

#### Focus on Code Clarity
- [ ] Is the code clear in its behavior and purpose?
- [ ] Does the code conform to the established architecture (or improve it)?
- [ ] Is there comments in the code for classes/interfaces/complex functions?

#### Focus on Code Quality
*Does the code conform to code cleanliness standards?*
- [ ] Does it adhere sufficiently to [SOLID](https://en.wikipedia.org/wiki/SOLID_(object-oriented_design)) and [YAGNI](https://en.wikipedia.org/wiki/You_aren%27t_gonna_need_it) principles?
- [ ] Does it have sufficiently few, if any, [Code Smells](https://en.wikipedia.org/wiki/Code_smell)\*\*?
- [ ] Does static analysis indicate sufficiently few violations?

#### Focus on Non-Functional Requirements
- [ ] Does number of database calls in a unit makes sense?
- [ ] Are database calls efficient and queries are viewed/approved by DBA?
- [ ] Does the code follow stateless design?
- [ ] Does the code avoid creating unnecessary large objects (such as DB connection)?
- [ ] Scalability, compatibility, usability, etc. considered?

> Look for **[Code Smells](https://en.wikipedia.org/wiki/Code_smell)**: include duplication, high cyclomatic complexity, multiple return points, unjustified layers of indirection, etc.
Check Sonar reports to get accurate report. 

###### Pull Request Message:
