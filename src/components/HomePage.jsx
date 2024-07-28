import React from 'react'
import NavBar from './NavBar'
import Home from './Home'
import { Home2 } from './Home2';
import Footer from './Footer';

const HomePage = () => {
  return (
    <div>
        <NavBar/>
        <Home/>
        <Home2/>
        <Footer/>
    </div>
  )
}

export default HomePage