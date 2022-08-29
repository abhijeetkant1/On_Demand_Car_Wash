import React, { useState } from 'react';
import axios from 'axios';
import "./Washpack.css";
import { useNavigate} from "react-router";
import {  toast } from 'react-toastify';


const Addpacks = () => {
  const navigate = useNavigate();
  const [pack, setPack] = useState({
    id: "",
    packname: "",
    description: "",
    cost: "",
  });
  const [formErrors, setFormErrors] = useState({});
  const handleChange = (event) => {
    event.persist();
    setPack((pack) => ({ ...pack, [event.target.name]: event.target.value }));
  };

  const handleSubmit = () => {
    let errors = {};

    if (!pack.id) {
      errors["packIdErr"] = "pack id is Required";
    }
    if (!pack.packname) {
      errors["packNameErr"] = "PackName is Required";
    }

    if (!pack.description) {
      errors["packDescriptionErr"] = "Pack Description is Required";
    }
    if (!pack.cost) {
      errors["packCostErr"] = "Pack Cost is Required";
    } else if (pack.cost < 0) {
      errors["packCostErr"] = "Pack Cost is Required";
    }

    setFormErrors(errors);
    const noErrors = Object.keys(errors).length === 0;
    if (noErrors) {
      const payload = {
        id: pack.id,
        packname: pack.packname,
        description: pack.description,
        cost: pack.cost,
      };
      axios.post("http://localhost:8084/admin/addwashpack", payload);
      
toast.success('Wash Pack with ID '+ pack.id + ' added Sucessfully...! ',
 {
 position: "top-center",
autoClose: 3000
});
 navigate("/admin_home")

}

}


  return (
    <div className='hero-containers'>
     <div className='in' >
        <div className='container' style={{width:"600px",float:"right",backgroundImage:"url(https://images.unsplash.com/photo-1553095066-5014bc7b7f2d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8d2FsbCUyMGJhY2tncm91bmR8ZW58MHx8MHx8&w=1000&q=80)"}}>
          <h2 className='title'  > Add packs</h2>
        <label style={{color: "white"}}> Id</label>
        <input
        id="id"
         className="form-control"
          type="number"
          min="0"
          name="id"
          value={pack.id}
          onChange={handleChange}
        />
        {formErrors.packIdErr && (
          <div style={{ color: "red", paddingBottom: 10 }}>
            {formErrors.packIdErr}
          </div>
        )}
      
     <br></br>
      
        <label style={{color: "white"}}>Pack Name</label>
        <input
        id="pname"
         className="form-control"
          type="text"
          name="packname"
          value={pack.packname}
          onChange={handleChange}
        />
         {formErrors.packNameErr && (
          <div style={{ color: "red", paddingBottom: 10 }}>
            {formErrors.packNameErr}
          </div>
        )}
      
      <br></br>
      
        <label style={{color: "white"}}>Description</label>
        <input
        id="description"
         className="form-control"
          type="text"
          name="description"
          value={pack.description}
          onChange={handleChange}
        />
         {formErrors.packDescriptionErr && (
          <div style={{ color: "red", paddingBottom: 10 }}>
            {formErrors.packDescriptionErr}
          </div>
        )}
        <br></br>
     
        <label style={{color: "white"}}>Cost</label>
        <input
        id="cost"
         className="form-control"
          type="number"
          min="0"
          name="cost"
          value={pack.cost}
          onChange={handleChange}
        />
         {formErrors.packCostErr && (
          <div style={{ color: "red", paddingBottom: 10 }}>
            {formErrors.packCostErr}
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

export default Addpacks;