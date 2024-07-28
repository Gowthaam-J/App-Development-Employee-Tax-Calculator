import React, { useState } from 'react';
import '../css/landingpage.css';
import NavBar from './NavBar';

export default function TaxCalculator() {
  const [activeStep, setActiveStep] = useState(0);
  const [formValues, setFormValues] = useState({
    assessmentYear: '',
    taxpayerType: '',
    taxCategory: '',
    gender: '',
    grossSalaryIncome: '',
    incomeFromOtherSources: '',
    incomeFromInterest: '',
    incomeFromRental: '',
    interestOnHomeLoanSelf: '',
    interestOnHomeLoanLetOut: '',
    lifeInsurance: '',
    providentFund: '',
    publicProvidentFund: '',
    nsc: '',
    ulip: '',
    elss: '',
    housingLoanPrincipal: '',
    fixedDeposit: '',
    npsSelfContribution: '',
    annuityPensionFund: '',
    otherInvestment: '',
    healthInsurance: '',
    seniorCitizenHealthInsurance: '',
    preventiveHealthCheckup: '',
    medicalExpenditureSeniorCitizen: '',
    additionalNpsContribution: '',
    employerNpsContribution: '',
    basicSalary: '',
    dearnessAllowance: '',
    hra: '',
    rentPaid: '',
    metroCity: ''
  });
  const [errors, setErrors] = useState({});

  const steps = ['Taxpayer Information', 'Income Details', 'Deductions', 'Allowances'];

  const handleNext = () => {
    if (validateStep(activeStep)) {
      setActiveStep((prevActiveStep) => prevActiveStep + 1);
    }
  };

  const handleBack = () => {
    setActiveStep((prevActiveStep) => prevActiveStep - 1);
  };

  const handleReset = () => {
    setActiveStep(0);
    setFormValues({
      assessmentYear: '',
      taxpayerType: '',
      taxCategory: '',
      gender: '',
      grossSalaryIncome: '',
      incomeFromOtherSources: '',
      incomeFromInterest: '',
      incomeFromRental: '',
      interestOnHomeLoanSelf: '',
      interestOnHomeLoanLetOut: '',
      lifeInsurance: '',
      providentFund: '',
      publicProvidentFund: '',
      nsc: '',
      ulip: '',
      elss: '',
      housingLoanPrincipal: '',
      fixedDeposit: '',
      npsSelfContribution: '',
      annuityPensionFund: '',
      otherInvestment: '',
      healthInsurance: '',
      seniorCitizenHealthInsurance: '',
      preventiveHealthCheckup: '',
      medicalExpenditureSeniorCitizen: '',
      additionalNpsContribution: '',
      employerNpsContribution: '',
      basicSalary: '',
      dearnessAllowance: '',
      hra: '',
      rentPaid: '',
      metroCity: ''
    });
    setErrors({});
  };

  const handleChange = (event) => {
    const { name, value } = event.target;
    setFormValues({ ...formValues, [name]: value });
  };

  const validateStep = (step) => {
    let tempErrors = {};
    let valid = true;

    switch (step) {
      case 0:
        if (!formValues.assessmentYear) {
          tempErrors.assessmentYear = 'Assessment Year is required';
          valid = false;
        }
        if (!formValues.taxpayerType) {
          tempErrors.taxpayerType = 'Taxpayer Type is required';
          valid = false;
        }
        if (!formValues.taxCategory) {
          tempErrors.taxCategory = 'Tax Category is required';
          valid = false;
        }
        if (!formValues.gender) {
          tempErrors.gender = 'Gender is required';
          valid = false;
        }
        break;
      case 1:
        if (!formValues.grossSalaryIncome) {
          tempErrors.grossSalaryIncome = 'Gross Salary Income is required';
          valid = false;
        }
        if (!formValues.incomeFromOtherSources) {
          tempErrors.incomeFromOtherSources = 'Annual Income from Other Sources is required';
          valid = false;
        }
        if (!formValues.incomeFromInterest) {
          tempErrors.incomeFromInterest = 'Annual Income from Interest is required';
          valid = false;
        }
        if (!formValues.incomeFromRental) {
          tempErrors.incomeFromRental = 'Annual Income from Let-Out House Property (Rental Income) is required';
          valid = false;
        }
        if (!formValues.interestOnHomeLoanSelf) {
          tempErrors.interestOnHomeLoanSelf = 'Annual Interest Paid on Home Loan (Self-Occupied) is required';
          valid = false;
        }
        if (!formValues.interestOnHomeLoanLetOut) {
          tempErrors.interestOnHomeLoanLetOut = 'Annual Interest Paid on Home Loan (Let-Out) is required';
          valid = false;
        }
        break;
      case 2:
        // Add validation for deductions
        break;
      case 3:
        // Add validation for allowances
        break;
      default:
        break;
    }

    setErrors(tempErrors);
    return valid;
  };
  const renderStepContent = (step) => {
    switch (step) {
      case 0:
        return (
          <div>
            <div className="form-group">
              <label>Assessment Year:</label>
              <input
                type="text"
                name="assessmentYear"
                value={formValues.assessmentYear}
                onChange={handleChange}
                />
              {errors.assessmentYear && <div className="error">{errors.assessmentYear}</div>}
            </div>
            <div className="form-group">
              <label>Taxpayer Type:</label>
              <input
                type="text"
                name="taxpayerType"
                value={formValues.taxpayerType}
                onChange={handleChange}
                />
              {errors.taxpayerType && <div className="error">{errors.taxpayerType}</div>}
            </div>
            <div className="form-group">
              <label>Tax Category:</label>
              <input
                type="text"
                name="taxCategory"
                value={formValues.taxCategory}
                onChange={handleChange}
                />
              {errors.taxCategory && <div className="error">{errors.taxCategory}</div>}
            </div>
            <div className="form-group">
              <label>Gender:</label>
              <input
                type="text"
                name="gender"
                value={formValues.gender}
                onChange={handleChange}
                />
              {errors.gender && <div className="error">{errors.gender}</div>}
            </div>
          </div>
        );
      case 1:
        return (
          <div>
            <div className="form-group">
              <label>Gross Salary Income:</label>
              <input
                type="text"
                name="grossSalaryIncome"
                value={formValues.grossSalaryIncome}
                onChange={handleChange}
                />
              {errors.grossSalaryIncome && <div className="error">{errors.grossSalaryIncome}</div>}
            </div>
            <div className="form-group">
              <label>Annual Income from Other Sources:</label>
              <input
                type="text"
                name="incomeFromOtherSources"
                value={formValues.incomeFromOtherSources}
                onChange={handleChange}
                />
              {errors.incomeFromOtherSources && <div className="error">{errors.incomeFromOtherSources}</div>}
            </div>
            <div className="form-group">
              <label>Annual Income from Interest:</label>
              <input
                type="text"
                name="incomeFromInterest"
                value={formValues.incomeFromInterest}
                onChange={handleChange}
                />
              {errors.incomeFromInterest && <div className="error">{errors.incomeFromInterest}</div>}
            </div>
            <div className="form-group">
              <label>Annual Income from Let-Out House Property (Rental Income):</label>
              <input
                type="text"
                name="incomeFromRental"
                value={formValues.incomeFromRental}
                onChange={handleChange}
                />
              {errors.incomeFromRental && <div className="error">{errors.incomeFromRental}</div>}
            </div>
            <div className="form-group">
              <label>Annual Interest Paid on Home Loan (Self-Occupied):</label>
              <input
                type="text"
                name="interestOnHomeLoanSelf"
                value={formValues.interestOnHomeLoanSelf}
                onChange={handleChange}
                />
              {errors.interestOnHomeLoanSelf && <div className="error">{errors.interestOnHomeLoanSelf}</div>}
            </div>
            <div className="form-group">
              <label>Annual Interest Paid on Home Loan (Let-Out):</label>
              <input
                type="text"
                name="interestOnHomeLoanLetOut"
                value={formValues.interestOnHomeLoanLetOut}
                onChange={handleChange}
                />
              {errors.interestOnHomeLoanLetOut && <div className="error">{errors.interestOnHomeLoanLetOut}</div>}
            </div>
          </div>
        );
        case 2:
          return (
          <div>
            <div className="form-group">
              <label>Life Insurance Premium Paid:</label>
              <input
                type="text"
                name="lifeInsurance"
                value={formValues.lifeInsurance}
                onChange={handleChange}
                />
              {errors.lifeInsurance && <div className="error">{errors.lifeInsurance}</div>}
            </div>
            <div className="form-group">
              <label>Contribution to Provident Fund:</label>
              <input
                type="text"
                name="providentFund"
                value={formValues.providentFund}
                onChange={handleChange}
                />
              {errors.providentFund && <div className="error">{errors.providentFund}</div>}
            </div>
            <div className="form-group">
              <label>Public Provident Fund:</label>
              <input
                type="text"
                name="publicProvidentFund"
                value={formValues.publicProvidentFund}
                onChange={handleChange}
                />
              {errors.publicProvidentFund && <div className="error">{errors.publicProvidentFund}</div>}
            </div>
            <div className="form-group">
              <label>Subscription to NSC:</label>
              <input
                type="text"
                name="nsc"
                value={formValues.nsc}
                onChange={handleChange}
                />
              {errors.nsc && <div className="error">{errors.nsc}</div>}
            </div>
            <div className="form-group">
              <label>Unit Linked Insurance Plan (ULIP):</label>
              <input
                type="text"
                name="ulip"
                value={formValues.ulip}
                onChange={handleChange}
              />
              {errors.ulip && <div className="error">{errors.ulip}</div>}
            </div>
            <div className="form-group">
              <label>Contribution to ELSS:</label>
              <input
                type="text"
                name="elss"
                value={formValues.elss}
                onChange={handleChange}
                />
              {errors.elss && <div className="error">{errors.elss}</div>}
            </div>
            <div className="form-group">
              <label>Principal Payment of Housing Loan:</label>
              <input
                type="text"
                name="housingLoanPrincipal"
                value={formValues.housingLoanPrincipal}
                onChange={handleChange}
                />
              {errors.housingLoanPrincipal && <div className="error">{errors.housingLoanPrincipal}</div>}
            </div>
            <div className="form-group">
              <label>Five-Year Fixed Deposit:</label>
              <input
                type="text"
                name="fixedDeposit"
                value={formValues.fixedDeposit}
                onChange={handleChange}
                />
              {errors.fixedDeposit && <div className="error">{errors.fixedDeposit}</div>}
            </div>
            <div className="form-group">
              <label>Self Contribution - National Pension Scheme 80CCD(1):</label>
              <input
                type="text"
                name="npsSelfContribution"
                value={formValues.npsSelfContribution}
                onChange={handleChange}
              />
              {errors.npsSelfContribution && <div className="error">{errors.npsSelfContribution}</div>}
            </div>
            <div className="form-group">
              <label>Contribution to Annuity/Pension Fund under 80CCC:</label>
              <input
                type="text"
                name="annuityPensionFund"
                value={formValues.annuityPensionFund}
                onChange={handleChange}
                />
              {errors.annuityPensionFund && <div className="error">{errors.annuityPensionFund}</div>}
            </div>
            <div className="form-group">
              <label>Other Investment Eligible under 80C/80CCC:</label>
              <input
                type="text"
                name="otherInvestment"
                value={formValues.otherInvestment}
                onChange={handleChange}
                />
              {errors.otherInvestment && <div className="error">{errors.otherInvestment}</div>}
            </div>
            <div className="form-group">
              <label>Health Insurance Premium:</label>
              <input
                type="text"
                name="healthInsurance"
                value={formValues.healthInsurance}
                onChange={handleChange}
                />
              {errors.healthInsurance && <div className="error">{errors.healthInsurance}</div>}
            </div>
            <div className="form-group">
              <label>Health Insurance Premium for Senior Citizen:</label>
              <input
                type="text"
                name="seniorCitizenHealthInsurance"
                value={formValues.seniorCitizenHealthInsurance}
                onChange={handleChange}
                />
              {errors.seniorCitizenHealthInsurance && <div className="error">{errors.seniorCitizenHealthInsurance}</div>}
            </div>
            <div className="form-group">
              <label>Preventive Health Checkup:</label>
              <input
                type="text"
                name="preventiveHealthCheckup"
                value={formValues.preventiveHealthCheckup}
                onChange={handleChange}
                />
              {errors.preventiveHealthCheckup && <div className="error">{errors.preventiveHealthCheckup}</div>}
            </div>
            <div className="form-group">
              <label>Medical Expenditure Paid on Health of Senior Citizen:</label>
              <input
                type="text"
                name="medicalExpenditureSeniorCitizen"
                value={formValues.medicalExpenditureSeniorCitizen}
                onChange={handleChange}
                />
              {errors.medicalExpenditureSeniorCitizen && <div className="error">{errors.medicalExpenditureSeniorCitizen}</div>}
            </div>
            <div className="form-group">
              <label>Additional NPS Self Contribution upto 50000 - 80CCD(1B):</label>
              <input
                type="text"
                name="additionalNpsContribution"
                value={formValues.additionalNpsContribution}
                onChange={handleChange}
                />
              {errors.additionalNpsContribution && <div className="error">{errors.additionalNpsContribution}</div>}
            </div>
            <div className="form-group">
              <label>Employer Contribution for NPS - 80CCD(2):</label>
              <input
                type="text"
                name="employerNpsContribution"
                value={formValues.employerNpsContribution}
                onChange={handleChange}
                />
              {errors.employerNpsContribution && <div className="error">{errors.employerNpsContribution}</div>}
            </div>
          </div>
        );
      case 3:
        return (
          <div>
            <div className="form-group">
              <label>Basic Salary Received per Annum:</label>
              <input
                type="text"
                name="basicSalary"
                value={formValues.basicSalary}
                onChange={handleChange}
                />
              {errors.basicSalary && <div className="error">{errors.basicSalary}</div>}
            </div>
            <div className="form-group">
              <label>Dearness Allowance (DA) Received per Annum:</label>
              <input
                type="text"
                name="dearnessAllowance"
                value={formValues.dearnessAllowance}
                onChange={handleChange}
                />
              {errors.dearnessAllowance && <div className="error">{errors.dearnessAllowance}</div>}
            </div>
            <div className="form-group">
              <label>HRA Received per Annum:</label>
              <input
                type="text"
                name="hra"
                value={formValues.hra}
                onChange={handleChange}
                />
              {errors.hra && <div className="error">{errors.hra}</div>}
            </div>
            <div className="form-group">
              <label>Total Rent Paid per Annum:</label>
              <input
                type="text"
                name="rentPaid"
                value={formValues.rentPaid}
                onChange={handleChange}
                />
              {errors.rentPaid && <div className="error">{errors.rentPaid}</div>}
            </div>
            <div className="form-group">
              <label>Do you live in a metro city?</label>
              <div className="radio-group">
                <label>
                  <input
                    type="radio"
                    name="metroCity"
                    value="Yes"
                    checked={formValues.metroCity === 'Yes'}
                    onChange={handleChange}
                    /> Yes
                </label>
                <label>
                  <input
                    type="radio"
                    name="metroCity"
                    value="No"
                    checked={formValues.metroCity === 'No'}
                    onChange={handleChange}
                    /> No
                </label>
              </div>
              {errors.metroCity && <div className="error">{errors.metroCity}</div>}
            </div>
          </div>
        );
        default:
          return <div>Unknown step</div>;
        }
      };

      return (
        <div className="stepper-container">
          {/* <NavBar/> */}
      <div className="stepper-header">
        {steps.map((label, index) => (
          <div key={index} className={`step ${index === activeStep ? 'active' : ''}`}>
            {label}
          </div>
        ))}
      </div>
      <div className="stepper-content">
        {renderStepContent(activeStep)}
      </div>
      <div className="stepper-footer">
        {activeStep > 0 && <button onClick={handleBack}>Back</button>}
        {activeStep < steps.length - 1 ? (
          <button onClick={handleNext}>Next</button>
        ) : (
          <button onClick={handleReset}>Reset</button>
        )}
      </div>
    </div>
  );
}
