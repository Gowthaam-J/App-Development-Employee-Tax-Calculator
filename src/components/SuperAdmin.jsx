import React, { useState } from 'react';
import '../css/landingpage.css';

const steps = [
  'Taxpayer Information',
  'Income Details',
  'Allowances',
  'Deductions',
  'Other Details'
];

export default function SimpleStepper() {
  const [activeStep, setActiveStep] = useState(0);
  const [formValues, setFormValues] = useState({
    taxpayerType: '',
    ageCategory: '',
    gender: '',
    salary: '',
    grossSalary: '',
    netSalary: '',
    otherIncome: '',
    hra: '',
    otherAllowances: '',
    deductions: {
      '80D': '',
      '80CCD': '',
    },
    otherDetails: '',
  });
  const [errors, setErrors] = useState({});

  const validateStep = (step) => {
    let newErrors = {};
    switch (step) {
      case 0:
        if (!formValues.taxpayerType) newErrors.taxpayerType = 'Required';
        if (!formValues.ageCategory) newErrors.ageCategory = 'Required';
        if (!formValues.gender) newErrors.gender = 'Required';
        break;
      case 1:
        if (!formValues.salary) newErrors.salary = 'Required';
        if (!formValues.grossSalary) newErrors.grossSalary = 'Required';
        if (!formValues.netSalary) newErrors.netSalary = 'Required';
        if (!formValues.otherIncome) newErrors.otherIncome = 'Required';
        break;
      case 2:
        if (!formValues.hra) newErrors.hra = 'Required';
        if (!formValues.otherAllowances) newErrors.otherAllowances = 'Required';
        break;
      case 3:
        if (!formValues.deductions['80D']) newErrors['80D'] = 'Required';
        if (!formValues.deductions['80CCD']) newErrors['80CCD'] = 'Required';
        break;
      case 4:
        if (!formValues.otherDetails) newErrors.otherDetails = 'Required';
        break;
      default:
        break;
    }
    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleNext = () => {
    if (!validateStep(activeStep)) return;

    setActiveStep((prevActiveStep) => prevActiveStep + 1);
  };

  const handleBack = () => {
    setActiveStep((prevActiveStep) => prevActiveStep - 1);
  };

  const handleReset = () => {
    setActiveStep(0);
    setFormValues({
      taxpayerType: '',
      ageCategory: '',
      gender: '',
      salary: '',
      grossSalary: '',
      netSalary: '',
      otherIncome: '',
      hra: '',
      otherAllowances: '',
      deductions: {
        '80D': '',
        '80CCD': '',
      },
      otherDetails: '',
    });
    setErrors({});
  };

  const handleChange = (event) => {
    const { name, value } = event.target;
    setFormValues((prevValues) => ({ ...prevValues, [name]: value }));
  };

  const handleDeductionsChange = (event) => {
    const { name, value } = event.target;
    setFormValues((prevValues) => ({
      ...prevValues,
      deductions: { ...prevValues.deductions, [name]: value }
    }));
  };

  const renderStepContent = (step) => {
    switch (step) {
      case 0:
        return (
          <div>
            <div className="form-group">
              <label>Taxpayer Type:</label>
              <input
                type="radio"
                name="taxpayerType"
                value="Individual"
                checked={formValues.taxpayerType === 'Individual'}
                onChange={handleChange}
              /> Individual
              <input
                type="radio"
                name="taxpayerType"
                value="HUF"
                checked={formValues.taxpayerType === 'HUF'}
                onChange={handleChange}
              /> HUF
              <input
                type="radio"
                name="taxpayerType"
                value="LLP"
                checked={formValues.taxpayerType === 'LLP'}
                onChange={handleChange}
              /> LLP
              <input
                type="radio"
                name="taxpayerType"
                value="Firms"
                checked={formValues.taxpayerType === 'Firms'}
                onChange={handleChange}
              /> Firms
              <input
                type="radio"
                name="taxpayerType"
                value="DomesticCompany"
                checked={formValues.taxpayerType === 'DomesticCompany'}
                onChange={handleChange}
              /> Domestic Company
              {errors.taxpayerType && <div className="error">{errors.taxpayerType}</div>}
            </div>
            <div className="form-group">
              <label>Age Category:</label>
              <input
                type="radio"
                name="ageCategory"
                value="Below 60"
                checked={formValues.ageCategory === 'Below 60'}
                onChange={handleChange}
              /> Below 60
              <input
                type="radio"
                name="ageCategory"
                value="Senior Citizen (<80 yr)"
                checked={formValues.ageCategory === 'Senior Citizen (<80 yr)'}
                onChange={handleChange}
              /> Senior Citizen ( &lt; 80 yr)
              <input
                type="radio"
                name="ageCategory"
                value="Super Senior Citizen (>80 yr)"
                checked={formValues.ageCategory === 'Super Senior Citizen (>80 yr)'}
                onChange={handleChange}
              /> Super Senior Citizen (&gt; 80 yr)
              {errors.ageCategory && <div className="error">{errors.ageCategory}</div>}
            </div>
            <div className="form-group">
              <label>Gender:</label>
              <input
                type="radio"
                name="gender"
                value="Male"
                checked={formValues.gender === 'Male'}
                onChange={handleChange}
              /> Male
              <input
                type="radio"
                name="gender"
                value="Female"
                checked={formValues.gender === 'Female'}
                onChange={handleChange}
              /> Female
              {errors.gender && <div className="error">{errors.gender}</div>}
            </div>
          </div>
        );
      case 1:
        return (
          <div>
            <div className="form-group">
              <label>Salary:</label>
              <input
                type="text"
                name="salary"
                value={formValues.salary}
                onChange={handleChange}
              />
              {errors.salary && <div className="error">{errors.salary}</div>}
            </div>
            <div className="form-group">
              <label>Gross Salary:</label>
              <input
                type="text"
                name="grossSalary"
                value={formValues.grossSalary}
                onChange={handleChange}
              />
              {errors.grossSalary && <div className="error">{errors.grossSalary}</div>}
            </div>
            <div className="form-group">
              <label>Net Salary:</label>
              <input
                type="text"
                name="netSalary"
                value={formValues.netSalary}
                onChange={handleChange}
              />
              {errors.netSalary && <div className="error">{errors.netSalary}</div>}
            </div>
            <div className="form-group">
              <label>Other Income:</label>
              <input
                type="text"
                name="otherIncome"
                value={formValues.otherIncome}
                onChange={handleChange}
              />
              {errors.otherIncome && <div className="error">{errors.otherIncome}</div>}
            </div>
          </div>
        );
      case 2:
        return (
          <div>
            <div className="form-group">
              <label>HRA:</label>
              <input
                type="text"
                name="hra"
                value={formValues.hra}
                onChange={handleChange}
              />
              {errors.hra && <div className="error">{errors.hra}</div>}
            </div>
            <div className="form-group">
              <label>Other Allowances:</label>
              <input
                type="text"
                name="otherAllowances"
                value={formValues.otherAllowances}
                onChange={handleChange}
              />
              {errors.otherAllowances && <div className="error">{errors.otherAllowances}</div>}
            </div>
          </div>
        );
      case 3:
        return (
          <div>
            <div className="form-group">
              <label>Section 80D:</label>
              <input
                type="text"
                name="80D"
                value={formValues.deductions['80D']}
                onChange={handleDeductionsChange}
              />
              {errors['80D'] && <div className="error">{errors['80D']}</div>}
            </div>
            <div className="form-group">
              <label>Section 80CCD:</label>
              <input
                type="text"
                name="80CCD"
                value={formValues.deductions['80CCD']}
                onChange={handleDeductionsChange}
              />
              {errors['80CCD'] && <div className="error">{errors['80CCD']}</div>}
            </div>
          </div>
        );
      case 4:
        return (
          <div>
            <div className="form-group">
              <label>Other Details:</label>
              <input
                type="text"
                name="otherDetails"
                value={formValues.otherDetails}
                onChange={handleChange}
              />
              {errors.otherDetails && <div className="error">{errors.otherDetails}</div>}
            </div>
          </div>
        );
      default:
        return null;
    }
  };

  return (
    <div className="container">
      <div className="stepper">
        {steps.map((label, index) => (
          <div
            key={label}
            className={`step ${index === activeStep ? 'active' : ''} ${index < activeStep ? 'completed' : ''}`}
            onClick={() => setActiveStep(index)}
          >
            {label}
          </div>
        ))}
      </div>
      {activeStep === steps.length ? (
        <div>
          <div>
            All steps completed - you're finished
          </div>
          <div>
            <button onClick={handleReset}>Reset</button>
          </div>
        </div>
      ) : (
        <div>
          {renderStepContent(activeStep)}
          <div className="buttons">
            <button onClick={handleBack} disabled={activeStep === 0}>
              Back
            </button>
            <button onClick={handleNext}>
              {activeStep === steps.length - 1 ? 'Finish' : 'Next'}
            </button>
          </div>
        </div>
      )}
    </div>
  );
}
