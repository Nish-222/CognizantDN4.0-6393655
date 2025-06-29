-- Scenario 1:
DECLARE
CURSOR c IS
SELECT c.Name,t.TransactionDate,t.Amount,t.TransactionType
FROM Customers c,Accounts a,Transactions t
WHERE c.CustomerID=a.CustomerID AND a.AccountID=t.AccountID
AND t.TransactionDate BETWEEN TRUNC(SYSDATE,'MM') AND LAST_DAY(SYSDATE);
BEGIN
FOR r IN c LOOP
DBMS_OUTPUT.PUT_LINE(r.Name||' - '||r.TransactionType||' of '||r.Amount);
END LOOP;
END;
/

-- Scenario 2:
DECLARE
CURSOR c IS SELECT AccountID FROM Accounts FOR UPDATE;
BEGIN
FOR a IN c LOOP
UPDATE Accounts SET Balance=Balance-100 WHERE AccountID=a.AccountID;
END LOOP;
COMMIT;
END;
/

-- Scenario 3:
DECLARE
CURSOR c IS SELECT LoanID,InterestRate FROM Loans FOR UPDATE;
BEGIN
FOR l IN c LOOP
UPDATE Loans SET InterestRate=
CASE WHEN l.InterestRate>6 THEN l.InterestRate-0.5
ELSE l.InterestRate+0.25 END
WHERE LoanID=l.LoanID;
END LOOP;
COMMIT;
END;
/