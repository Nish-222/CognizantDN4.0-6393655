-- Scenario 1:
CREATE OR REPLACE PROCEDURE SafeTransferFunds(p_From NUMBER,p_To NUMBER,p_Amount NUMBER)IS
v_Bal NUMBER;
BEGIN
SELECT Balance INTO v_Bal FROM Accounts WHERE AccountID=p_From FOR UPDATE;
IF v_Bal<p_Amount THEN
    RAISE_APPLICATION_ERROR(-20001,'Insufficient funds');
END IF;
UPDATE Accounts SET Balance=Balance-p_Amount WHERE AccountID=p_From;
UPDATE Accounts SET Balance=Balance+p_Amount WHERE AccountID=p_To;
COMMIT;
EXCEPTION
WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error: '||SQLERRM);
END;
/

-- Scenario 2:
CREATE OR REPLACE PROCEDURE UpdateSalary(p_EmpID NUMBER,p_Percent NUMBER)IS
BEGIN
UPDATE Employees SET Salary=Salary+(Salary*p_Percent/100) WHERE EmployeeID=p_EmpID;
IF SQL%ROWCOUNT=0 THEN
    RAISE_APPLICATION_ERROR(-20002,'Employee not found');
END IF;
COMMIT;
EXCEPTION
WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error: '||SQLERRM);
END;
/

-- Scenario 3:
CREATE OR REPLACE PROCEDURE AddNewCustomer(p_ID NUMBER,p_Name VARCHAR2,p_DOB DATE,p_Balance NUMBER)IS
BEGIN
INSERT INTO Customers(CustomerID,Name,DOB,Balance,LastModified)
VALUES(p_ID,p_Name,p_DOB,p_Balance,SYSDATE);
COMMIT;
EXCEPTION
WHEN DUP_VAL_ON_INDEX THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error: Customer already exists');
END;
/