-- Scenario 1:
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
UPDATE Accounts SET Balance=Balance+(Balance*0.01) WHERE AccountType='Savings';
COMMIT;
END;
/

-- Scenario 2:
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(p_Dept VARCHAR2,p_Bonus NUMBER)IS
BEGIN
UPDATE Employees SET Salary=Salary+(Salary*p_Bonus/100) WHERE Department=p_Dept;
COMMIT;
END;
/

-- Scenario 3:
CREATE OR REPLACE PROCEDURE TransferFunds(p_From NUMBER,p_To NUMBER,p_Amount NUMBER)IS
v_Bal NUMBER;
BEGIN
SELECT Balance INTO v_Bal FROM Accounts WHERE AccountID=p_From FOR UPDATE;
IF v_Bal<p_Amount THEN
    RAISE_APPLICATION_ERROR(-20003,'Insufficient funds');
END IF;
UPDATE Accounts SET Balance=Balance-p_Amount WHERE AccountID=p_From;
UPDATE Accounts SET Balance=Balance+p_Amount WHERE AccountID=p_To;
COMMIT;
EXCEPTION
WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Transfer failed: '||SQLERRM);
END;
/