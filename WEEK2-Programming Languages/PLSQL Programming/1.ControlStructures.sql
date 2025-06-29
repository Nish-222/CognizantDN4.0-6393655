--Senario 1:
BEGIN
FOR c IN(SELECT CustomerID FROM Customers WHERE MONTHS_BETWEEN(SYSDATE,DOB)/12>60)LOOP
    UPDATE Loans SET InterestRate=InterestRate-1 WHERE CustomerID=c.CustomerID;
END LOOP;
END;
/

-- Scenario 2:
BEGIN
FOR c IN(SELECT CustomerID FROM Customers WHERE Balance>10000)LOOP
    UPDATE Customers SET IsVIP=TRUE WHERE CustomerID=c.CustomerID;
END LOOP;
END;
/

-- Scenario 3:
BEGIN
FOR r IN(
    SELECT l.LoanID,c.Name FROM Loans l,Customers c
    WHERE l.CustomerID=c.CustomerID AND l.EndDate BETWEEN SYSDATE AND SYSDATE+30
)LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan '||r.LoanID||' for '||r.Name||' is due soon.');
END LOOP;
END;
/