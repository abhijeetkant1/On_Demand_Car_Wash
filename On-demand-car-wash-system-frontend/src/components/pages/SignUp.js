import React, {  useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router";
import { Link } from "react-router-dom";
import 'react-toastify/dist/ReactToastify.css';
// import toast from "react";
import { toast } from 'react-toastify';
toast.configure()

/**To Show Add Toastify Text */
const notify = () => {
  toast.success('Registered Successfully!!',
    {
      position: "top-center",
      autoClose: 3000
    });

}

function SignUp() {
  const [user, setUser] = useState({
    name: "",
    email: "",
    contactno: "",
    username: "",
    password: "",
    confirmpassword: "",
    
  
  });

  const navigate = useNavigate();

  const [formErrors, setFormErrors] = useState({});

  const handleChange = (event) => {
    event.persist();
    setUser((user) => ({
      ...user,
      [event.target.name]: event.target.value,
    }));
  };
  const handleSubmit = () => {
    
    let errors = {};
   
    if (!user.name) {
      errors["nameErr"] = "Name is required";
    }
    if (typeof user.name !== "undefined") {
      var pattern = new RegExp(/^[A-Za-z]+$/);
      if (!pattern.test(user.name)) {
        errors["nameErr"] =
          "Please type only character not number or special character";
      }
    }

    

    

    if (!user.email) {
      errors["emailIdErr"] = "Please enter your email Address.";
    }

    if (typeof user.email !== "undefined") {
      var pattern = new RegExp(/^\w+([\.-]?\w+)@\w+([\.-]?\w+)(\.\w{2,3})+$/);
      if (!pattern.test(user.email)) {
        errors["emailIdErr"] = "Please enter valid email address.";
      }
    }

    if (!user.contactno) {
      errors["contactNumberErr"] = "contactNumber is required";
    }
    if (typeof user.contactno !== "undefined") {
      var pattern = new RegExp(/^[0-9\b]+$/);
      if (!pattern.test(user.contactno)) {
        // isValid = false;
        errors["contactNumberErr"] = "Please enter only number.";
      } else if (user.contactno.length != 10) {
        // isValid = false;
        errors["contactNumberErr"] = "Please enter valid phone number.";
      }
    }

    if (!user.username) {
      errors["userNameErr"] = "userName is required";
    }
    if (!user.password) {
      errors["passwordErr"] = "password is required";
    }
    if (!user.confirmpassword) {
      errors["ConfirmpasswordErr"] = "confirmpassword is required";
    }
    setFormErrors(errors);
    const noErrors = Object.keys(errors).length === 0;
    if (noErrors) {
      const payload = {
        name: user.name,
        email: user.email,
        contactno:user.contactno,
        username: user.username,
        password: user.password,
        confirmpassword:user.confirmpassword
      };
      axios
        .post("http://localhost:8083/user/adduser", payload)
        .then((resp) =>
        {
          toast.success('User Added Successfully!!',
            {
              position: "top-center",
              autoClose: 3000
            });
        })
        .catch((err) => {
          notify();
        });
    }
  }

  return (
    <div className='hero-containers'>
    <div className="userlogin-container">
      <h2 className="user-panel" style={{color: "green"}}>USER REGISTRATION</h2>
          <hr></hr>
          <div className="userregisterform">
        
        <div className="username">
          <label className="form__label" for="firstName" style={{color: "white"}}>
             Name
          </label>
          <input
            className="form__input"
            id="fname"
            // className="form-control"
            type="text"
            name="name"
            placeholder="First Name"
            value={user.name}
            onChange={handleChange}
          />
          {formErrors.nameErr && (
            <div style={{ color: "red", paddingBottom: 10 }}>
              {formErrors.nameErr}
            </div>
          )}
       

        <div className="email">
          <label className="form__label" for="email" style={{color: "white"}}>
            Email ID
          </label>
          <input
            id="email"
            className="form__input"
            type="email"
            name="email"
            placeholder="Email Id"
            value={user.email}
            onChange={handleChange}
          />
          {formErrors.emailIdErr && (
            <div style={{ color: "red", paddingBottom: 10 }}>
              {formErrors.emailIdErr}
            </div>
          )}
        </div>
        <div className="contact">
          <label className="form__label" for="contact" style={{color: "white"}}>
            Contact No
          </label>
          <input
            id="contactno"
            className="form__input"
            type="text"
            name="contactno"
            placeholder="Mobile Number"
            value={user.contactno}
            onChange={handleChange}
          />
          {formErrors.contactNumberErr && (
            <div style={{ color: "red", paddingBottom: 10 }}>
              {formErrors.contactNumberErr}
            </div>
          )}
        </div>
        <div className="username">
          <label className="form__label" for="userName" style={{color: "white"}}>
            User Name
          </label>
          <input
            id="username"
            className="form__input"
            type="text"
            name="username"
            placeholder="User Name"
            value={user.username}
            onChange={handleChange}
          />
          {formErrors.userNameErr && (
            <div style={{ color: "red", paddingBottom: 10 }}>
              {formErrors.userNameErr}
            </div>
          )}
        </div>

        <div className="password">
          <label className="form__label" for="password" style={{color: "white"}}>
            Password
          </label>
          <input
            id="password"
            className="form__input"
            type="password"
            name="password"
            placeholder="PassWord"
            value={user.password}
            onChange={handleChange}
          />
          {formErrors.passwordErr && (
            <div style={{ color: "red", paddingBottom: 10 }}>
              {formErrors.passwordErr}
            </div>
          )}
        </div>
        <div className="Cpassword">
          <label className="form__label" for="password" style={{color: "white"}}>
           Confirm Password
          </label>
          <input
            id="confirmpassword"
            className="form__input"
            type="password"
            name="confirmpassword"
            placeholder="confirmPassWord"
            value={user.confirmpassword}
            onChange={handleChange}
          />
          {formErrors.ConfirmpasswordErr && (
            <div style={{ color: "red", paddingBottom: 10 }}>
              {formErrors.ConfirmpasswordErr}
            </div>
          )}
        </div>
      </div>
      <div className="footer">
        <button
          type="submit"
          class="btn"
          style={{ backgroundColor: "blue" }}
          onClick={handleSubmit}
        >
          Register
        </button>
      </div>
      </div><br/><br/>
      <p className="a" style={{ color: "orange" }}>Do u have an account ?<a href='/Login'>Login</a></p><br />
          <p className="a" style={{ color: "orange" }}>Login as Member..?  <a href='/WasherLog'> Login</a></p>
          <div className="mrginlistalltrainer" style={{fontSize:"30Px",marginLeft:"40px", marginTop: "40px"}}> <a class="previous">&laquo;</a>



<Link to="/"  style={{color:"chocolate"}} className="previous round">Back</Link> </div>
    </div>
    </div>
    
  );
}
export default SignUp