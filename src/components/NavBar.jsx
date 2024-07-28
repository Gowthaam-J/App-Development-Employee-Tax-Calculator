import React from 'react';
import { Link } from 'react-router-dom';
import logo from '../Logo.png';
import '../css/NavBar.css';
const NavBar = () => {
    return (
    <div>
        <div className='NavBarr'>
            <div className='Logo'>
                <img src={logo} style={{width:'7rem'}}/>
            </div>
            
            <div className='flex-containerr2'>
                    <div className='nav-elementss'>
                    <button className='buttonn'>
                        Home
                        </button>
                        </div>
                    <div className='nav-elementss'>
                    <button className='buttonn'>
                        Manage
                        </button>
                        </div>
                    <div className='nav-elementss'>
                    <button className='buttonn'>
                        Contact Us
                        </button>
                        </div>
                    <div className='nav-elementss'>
                    <button className='buttonn'>
                        About
                        </button>
                        </div>
            </div>
            <div className='flex-container'>
                    <div className='nav-elementss'>
                        <Link to="/register" style={{all:'unset'}}>
                        <button className='buttonn'>
                        Register
                        </button>
                        </Link>

                        </div>
                    <div className='nav-elementss'>
                    <Link  to='/signup' style={{all:'unset'}}>
                    <button className='buttonn'>
                       SignUp
                        </button>
                        </Link>
                        </div>
                    <div className='nav-elementss'>
                        <Link to='/login' style={{all:'unset'}}>
                        <button className='buttonn'>
                        Login
                        </button>
                        </Link>

                        </div>
            </div>
        </div>
    </div>
  )
}

export default NavBar