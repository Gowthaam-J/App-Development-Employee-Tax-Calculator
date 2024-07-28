import React from 'react'
import Lottie from 'react-lottie';
import Magic from '../Animation - 1721990179610.json';
import '../css/Home.css'
import  Button from '@mui/material/Button';
import { ArrowBack, ArrowForwardIos } from '@mui/icons-material';
import { Link } from 'react-router-dom';
const Home = () => {
    const defaultOptions ={
        loop:true,
        autoplay:true,
        animationData : Magic,
        renderSettings:{
          preserveAspectRatio: "xMidYMid slice"
        }
      };
  return (
    <div className='home'>
        <div className='flex1'>
        <div className='wrap'>
            <div className='head'>
            Simplify Your Tax Management with Ease..!
            </div>
            <div className='body'>
            Effortlessly manage accurate tax calculations and compliance with a streamlined solution that automates tax management for employees and companies, ensuring efficiency and precision while simplifying the entire process.
            </div>
            <div className='Button'>
               <Link to='/manage' style={{all:'unset'}}> <Button variant="contained" endIcon={<ArrowForwardIos/>}>
                Manage Tax
            </Button>
        </Link>
            </div>

        </div>
        <div className='logo'>
        <Lottie options={defaultOptions} width={400} height={400}/>
        </div>
    </div>
    </div>
  )
}

export default Home