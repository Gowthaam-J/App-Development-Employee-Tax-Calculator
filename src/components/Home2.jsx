import React from 'react'
import '../css/Home2.css'
import  Register from '../Register company.json';
import Lottie from 'react-lottie';
import Manage from '../Mange.json';
import taxation from'../taxation.json';
import { Button } from '@mui/material';
import { LineAxisSharp, LineAxisTwoTone, LinkOffSharp, LinkSharp } from '@mui/icons-material';
export const Home2 = () => {
    const defaultOptions ={
        loop:true,
        autoplay:true,
        animationData : Register,
        renderSettings:{
        preserveAspectRatio: "xMidYMid slice"
        }
      };
    const defaultOptions2 ={
        loop:true,
        autoplay:true,
        animationData : Manage,
        renderSettings:{
        preserveAspectRatio: "xMidYMid slice"
        }
      };
    const defaultOptions3 ={
        loop:true,
        autoplay:true,
        animationData : taxation,
        renderSettings:{
        preserveAspectRatio: "xMidYMid slice"
        }
      };
  return (
    <div>
            <div className='home2'>
                <div className='body1'>
                    <div className='part2'>
                    <Lottie options={defaultOptions} width={350} height={350}/>
                    </div>
                    <div className='part1'>
                        <div className='head2'>
                            Register your company
                        </div>
                        <div className='body2'>
                        Automate tax calculations and streamline employee tax management effortlessly. Ensure compliance and accuracy while exploring ways to minimize taxes. Save time, reduce administrative burdens, and provide transparency and convenience for both HR and employees. Simplify the tax management process and enhance financial efficiency for your organization.</div>
                    </div>
                </div>
                <div className='body1'>
                    <div className='part1'>
                        <div className='head2'>
                            Effective Taxation
                        </div>
                        <div className='body2'>
                        "Achieve effective taxation with automated calculations and strategic tax management. Ensure compliance and accuracy while exploring ways to minimize tax liabilities. Save time, reduce administrative burdens, and enhance financial efficiency for your organization with transparent and convenient tax solutions."</div>
                    </div>
                    <div className='part2'>
                    <Lottie options={defaultOptions2} width={350} height={350}/>
                    </div>
                </div>
                <div className='body1'>
                    <div className='part2'>
                    <Lottie options={defaultOptions3} width={350} height={350}/>
                    </div>
                    <div className='part1'>
                        <div className='head2'>
                            Learn Taxation
                        </div>
                        <div className='body2'>
                        Taxes are an important and largest source of income for the government. The government uses the money collected from taxes for various projects for the development of the nation. The Indian tax system is well structured and has a three-tier federal structure
                        <Button variant='text' href='https://www.canarahsbclife.com/tax-university/articles/all-about-tax-structure-in-india' endIcon={<LinkSharp/>}>Learn more</Button>.
                        </div>
                    </div>
                </div>
            </div>
    </div>
  )
}
