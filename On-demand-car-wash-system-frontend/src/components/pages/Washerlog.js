import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "./login.css";
//import Signup from "./SignUp";
import { Link } from "react-router-dom";
import {  toast } from 'react-toastify';


const WasherLogin = () => {
  let navigate = useNavigate();
  const [name, setName] = useState("");
  const [pass, setPss] = useState("");
  const [nameErr, setNameErr] = useState(false);
  const [passErr, setpassErr] = useState(false);

  const handleName = (e) => {
    setName(e.target.value);
    setNameErr(false);
  };
  const handlePass = (e) => {
    setPss(e.target.value);
    setpassErr(false);
  };
  const handleClick = () => {
    if (name && pass) {
      const data = {
        name: name,
        password: pass,
      };
      if (name === "admin" && pass === "1234") {
        axios
          .post("http://localhost:8082/washer/login", data)
          .then(function (response) {
            if (response && response.data) {
              if (response.data === "logged in") {
                navigate("/washerhome");
              } else {
                alert("wrong credentials.");
              }
            }
          })
          .catch(function (error) {
            console.log(error);
          });
      } else {
        axios
          .post("http://localhost:8082/washer/login", data)
          .then(function (response) {
            if (response && response.data) {
            if (response.data === "logged in") {
            // alert("Welcome " + loginForm.username);
           toast.success('Welcome '+ name,
            {
           position: "top-center",
            autoClose: 3000
           });
           let user={

            id:response.data.id,



            name: response.data.name



        }



        localStorage.setItem("myUser",JSON.stringify(user));
           navigate("/washerhome");
            } else {
           alert("wrong credentials.");
            }
            }
            })
           .catch(function (error) {
           console.log(error);
           });
           
           
                 }
    } else if (name) {
      setpassErr(true);
      setNameErr(false);
    } else if (pass) {
      setNameErr(true);
      setpassErr(false);
    } else {
      setpassErr(true);
      setNameErr(true);
    }
  };
  // 

  return (
    <div className="userbg">
    <div>
      <h1 className="title1a">WASHER LOGIN</h1>
      <div className="login-form">
        <div className="input-container">
          <label>Username</label>
          <input
            type="text"
            placeholder="  Enter Username"
            value={name}
            onChange={handleName}
          />
          {nameErr && <span style={{color:"red"}}>Enter valid name</span>}
          <label>Password</label>
          <input
            type="password"
            placeholder="password"
            value={pass}
            onChange={handlePass}
          />
          {passErr && <span style={{color:"red"}}>Enter valid password</span>}
        </div>
        <button className="Btn" onClick={handleClick}>
          Submit
        </button>
        <div className="mrginlistalltrainer" style={{fontSize:"30Px",marginLeft:"40px", marginTop: "40px"}}> <a class="previous">&laquo;</a>

             <Link to="/"  style={{color:"chocolate"}} className="previous round">Back</Link> </div>

            <div className='col-10 col-md-8 col-lg-6'style={{  marginTop: "60px" }}></div>
      </div>
    </div>
    </div>
  );
};

export default WasherLogin;
