import { Route, Routes } from 'react-router-dom';
import AdminPage from './components/AdminPage';
import './css/App.css';
import HomePage from './components/HomePage';
import SignUp from './components/Signup';
import Login from './components/Login';
import SuperAdminForm from './components/SuperAdmin';
import SimpleStepper from './components/landingpage.jsx';
function App() {
  return (
    <div className="App">
      {/* <TaxCalculator/> */}
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/admin" element={<AdminPage />} />
        <Route path='/signup' element={<SignUp/>}/>
        <Route path='/login' element={<Login/>}/>
        <Route path='/register' element={<SuperAdminForm/>}/>
        <Route path='/manage' element={<SimpleStepper/>}/>
      </Routes>
      {/* <SimpleStepper/> */}
      {/* <AdminPage/> */}
      {/* <SuperAdminForm/> */}
    </div>
  );
}

export default App;
