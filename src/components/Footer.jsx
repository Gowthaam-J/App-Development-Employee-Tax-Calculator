import React from 'react';
import { FaFacebook, FaTwitter, FaLinkedin, FaInstagram } from 'react-icons/fa';
import '../css/Footer.css';

const Footer = () => {
  return (
    <footer className="footer">
      <div className="footer-container">
        <div className="footer-section">
          <h4>About Us</h4>
          <p>We are a leading company in our industry, committed to providing quality services and solutions to our customers. Our team of experts is dedicated to ensuring customer satisfaction and delivering exceptional results. Join us in our journey to innovate and excel in our field.</p>
        </div>
        <div className="footer-section">
          <h4>Contact Us</h4>
          <p>Email: contact@fiscalnet.com</p>
          <p>Phone: +123 456 7890</p>
          <p>Address: 123 New Street, Delhi, India </p>
          <p>For any inquiries or assistance, feel free to reach out to us. We are here to help you with all your needs.</p>
        </div>
        <div className="footer-section">
          <h4>Follow Us</h4>
          <div className="social-icons">
            <a href="https://www.facebook.com" target="_blank" rel="noopener noreferrer">
              <FaFacebook size={36} />
            </a>
            <a href="https://www.twitter.com" target="_blank" rel="noopener noreferrer">
              <FaTwitter size={36} />
            </a>
            <a href="https://www.linkedin.com" target="_blank" rel="noopener noreferrer">
              <FaLinkedin size={36} />
            </a>
            <a href="https://www.instagram.com" target="_blank" rel="noopener noreferrer">
              <FaInstagram size={36} />
            </a>
          </div>
        </div>
      </div>
      <div className="footer-bottom">
        <p>&copy; {new Date().getFullYear()} Fiscal Net. All Rights Reserved.</p>
      </div>
    </footer>
  );
};

export default Footer;
