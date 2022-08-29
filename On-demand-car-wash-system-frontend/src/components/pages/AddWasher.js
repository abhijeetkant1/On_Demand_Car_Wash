import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router";

import {Link} from "react-router-dom";

function WashersignUp() {
  const [washer, setWasher] = useState({
        id: "",
        location: "",
        name: "",
        password: ""
  });

  const navigate=useNavigate();
  const [formErrors, setFormErrors] = useState({});

  const handleChange = (event) => {
    event.persist();
    setWasher((washer) => ({
      ...washer,
      [event.target.name]: event.target.value,
    }));
  };

  const handleSubmit = () => {
    let errors = {};

    if (!washer.id) {
      errors["idErr"] = "Enter  Id";
    }

    if (!washer.location) {
      errors["locationErr"] = "Enter location";
    }

    if (!washer.name) {
      errors["nameErr"] = "Enter Name";
    }
    if (!washer.password) {
        errors["passwordErr"] = "Enter password";
      }

    setFormErrors(errors);

    const noErrors = Object.keys(errors).length === 0;

    if (noErrors) {
      const payload = {
        id: washer.id,
        location: washer.location,
        name: washer.name,
        password: washer.password,
      }

      axios
        .post("http://localhost:8082/washer/addwasher", payload)

        .then((resp) => alert("Washer is added with id:" + resp.data.Id));
        console.log("DONE");
        navigate(-1);
    }
  };
  return (
    <div className='hero-containers'>
    <div className='in'>
       <div className='container' style={{width:"600px",float:"right",backgroundImage:"url(https://png.pngtree.com/thumb_back/fh260/background/20200714/pngtree-modern-double-color-futuristic-neon-background-image_351866.jpg)"}}>
         <h2 className='title'  > Add Washer</h2>
       <label style={{color: "white"}}> Id</label>
       <input
       id="id"
        className="form-control"
         type="number"
         min="0"
         name="id"
         value={washer.id}
         onChange={handleChange}
       />
       {formErrors.idErr && (
         <div style={{ color: "red", paddingBottom: 10 }}>
           {formErrors.idErr}
         </div>
       )}
     
    <br></br>
     
       <label style={{color: "white"}}>Location</label>
       <input
       id="pname"
        className="form-control"
         type="text"
         name="location"
         value={washer.location}
         onChange={handleChange}
       />
        {formErrors.locationErr && (
         <div style={{ color: "red", paddingBottom: 10 }}>
           {formErrors.locationErr}
         </div>
       )}
     
     <br></br>
     
       <label style={{color: "white"}}>Name</label>
       <input
       id="description"
        className="form-control"
         type="text"
         name="name"
         value={washer.name}
         onChange={handleChange}
       />
        {formErrors.nameErr && (
         <div style={{ color: "red", paddingBottom: 10 }}>
           {formErrors.nameErr}
         </div>
       )}
       <br></br>
    
       <label style={{color: "white"}}>Password</label>
       <input
       id="cost"
        className="form-control"
         type="text"
         name="password"
         value={washer.password}
         onChange={handleChange}
       />
        {formErrors.passwordErr && (
         <div style={{ color: "red", paddingBottom: 10 }}>
           {formErrors.passwordErr}
         </div>
       )}
     <br></br>

     <div >
           <button className="btn btn-outline-light btn-lg px-5" type="submit" onClick={handleSubmit } >Submit</button>
           </div>
   </div>
   </div>
   </div>
 );
}

export default WashersignUp;