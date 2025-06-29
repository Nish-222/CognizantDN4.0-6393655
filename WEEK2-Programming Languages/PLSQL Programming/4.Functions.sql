-- Scenario 1:
CREATE OR REPLACE FUNCTION CalculateAge(p_DOB DATE)RETURN NUMBER IS
BEGIN
RETURN FLOOR(MONTHS_BETWEEN(SYSDATE,p_DOB)/12);
END;
/

-- Scenario 2:
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(p_Loan NUMBER,p_Rate NUMBER,p_Years NUMBER)RETURN NUMBER IS
r NUMBER:=p_Rate/1200;
n NUMBER:=p_Years*12;
BEGIN
RETURN p_Loan*r/(1-POWER(1+r,-n));
END;
/

-- Scenario 3:
CREATE OR REPLACE FUNCTION HasSufficientBalance(p_AccID NUMBER,p_Amount NUMBER)RETURN BOOLEAN IS
v_Bal NUMBER;
BEGIN
SELECT Balance INTO v_Bal FROM Accounts WHERE AccountID=p_AccID;
RETURN v_Bal>=p_Amount;
END;
/