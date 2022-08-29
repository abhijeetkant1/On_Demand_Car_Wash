import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
// import './Navbar.css';
import { useNavigate } from "react-router";
function AdminNavbar() {
  const myUser = JSON.parse(localStorage.getItem("myUser"));



  const navigate = useNavigate();



  const adminLogout = () => {

    if (myUser != null) {

      localStorage.removeItem("myUser");



      localStorage.clear();



      alert("You have successfully logout.........");

      navigate("/");

    }

  };
  const [click, setClick] = useState(false);
  const [button, setButton] = useState(true);

  const handleClick = () => setClick(!click);
  const closeMobileMenu = () => setClick(false);

  

  const showButton = () => {
    if (window.innerWidth <= 960) {
      setButton(false);
    } else {
      setButton(true);
    }
  };

  useEffect(() => {
    showButton();
  }, []);

  window.addEventListener('resize', showButton);


  return (
    <>

      <nav className="navbar navbar-expand navbar-dark bg-dark">

        <Link to={"/"} className="navbar-brand">
          Green Wash Car Wash
        </Link>
        <div className="navbar-nav mr-auto">
          <li className="nav-item">
            <Link to={"/"} className="nav-link">
              Home
            </Link>
          </li>

          <li className="nav-item">
            <Link to={"/admin_pack"} className='nav-link'>
              Packages
            </Link>
          </li>
          <li className="nav-item">
            <Link to={"/About"} className='nav-link'>
              About Us
            </Link>
          </li>

          <li className="nav-item">
            <Link to={"/Profile"} className='nav-link'>
             User Profiles
            </Link>
          </li>
          <li className="nav-item">
            <Link to={"/WasherProfile"} className='nav-link'>
             Washer Profiles
            </Link>
          </li>

          <li className="nav-item">
            <Link to={"/addpacks"} className='nav-link'>
              Add Packages
            </Link>
          </li>
          <li className="nav-item">
            <Link to={"/addwasher"} className='nav-link'>
              Add Washer
            </Link>
          </li>
        </div>
        <div className="ms-auto pe-md-5 navbar-nav">
        
          <li className='nav-item'>
            <Link to='/' onClick={adminLogout} className='nav-link'>
               Logout
            </Link>
          </li>
         
        </div>



      </nav>
    </>
  );
}
export default AdminNavbar;