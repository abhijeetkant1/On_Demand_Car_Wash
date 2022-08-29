import React from 'react';
import '../../App.css';
import Footer from '../Footer';
import Admin from './Admin';
import AdminNavbar from './AdminNab';
import UserNavbar from './UserNavbar';
import UserPack from './UserPack';

function UserHome() {
  return (
    <>
       <UserNavbar/>
    <UserPack/>
       <Footer/>
    </>
  );
}

export default UserHome;
