// import { toBeEmpty } from "@testing-library/jest-dom";
import axios from "axios";
import React from "react";
import { useState, useEffect } from "react";
import "./booking.css";
import { useNavigate } from "react-router-dom";
import Footer from "./Footer";
import { toast } from "react-toastify";

function Booking() {
  // const [washers, setWashers] = useState([]);

  // useEffect(() => {
  //   fetch("http://localhost:8084/admin/washpack").then((result) => {
  //     result.json().then((resp) => {
  //       setWashers(resp);
  //       console.log(resp);
  //     });
  //   });
  // }, []);

  const [order, setOrder] = useState({
    carModel: "",
    carName: "",
    contactno: "",
    date: "",
    orderId: "",
    username: "",
    address: "",
    //cost: ""
  });

  const navigate = useNavigate();

  const [formErrors, setFormErrors] = useState({});

  const handleSubmit = (event) => {
    event.persist();
    setOrder((order) => ({
      ...order,
      [event.target.name]: event.target.value,
    }));
  };
  const handleChange = () => {
    //validate add student form
    let errors = {};
    // const isValid=isValid();
    if (!order.carName) {
      errors["carNameErr"] = "carName is required";
    }
    if (!order.carModel) {
      errors["carModelErr"] = "Vechile Type is required";
    }

    if (!order.contactno) {
      errors["contactnoErr"] = "contact no is required";
    }
    if (!order.date) {
      errors["dateErr"] = "date is required";
    }
    // if (!order.cost) {
    //   errors["costErr"] = "cost is required";
    // }
    if (!order.username) {
      errors["usernameErr"] = "username is required";
    }
    if (!order.address) {
      errors["addressErr"] = "address is required";
    }
    setFormErrors(errors);
    const noErrors = Object.keys(errors).length === 0;
    if (noErrors) {
      const payload = {
        carModel: order.carModel,
        carName: order.carName,
        contactno: order.contactno,
        date: order.date,
        orderId: order.orderId,
        username: order.username,
        address: order.address,
        //cost: order.cost
      };
      axios
        .post(" http://localhost:8081/order/addorder", payload)
        .then(function (response) {
          if (response && response.data) {
            toast.success("Order Placed Proceeding to payment ", {
              position: "top-center",

              autoClose: 3000,
            });
          }

          navigate("/Payment");
        })

        .catch(function (error) {
          console.log(error);
        });
    }
  };
  return (
    <div className="hero-containers">
      <div className="formDetails" style={{ marginTop: "7%" }}>
        <div className="formTop">
          <div className="formTitle">
            <p className="c1">
              <h1 style={{ color: "red" }}>BOOK YOUR CAR WASH </h1>
            </p>
          </div>
        </div>
        <h1 style={{ color: "orange" }}>Contact Details</h1>

        <div className="ContactDetails">
          <h3 style={{ color: "green" }}>Date for Booking</h3>
          <input type="date" name="date" onChange={handleSubmit} />
          {formErrors.dateErr && (
            <div style={{ color: "red", paddingBottom: 10 }}>
              {formErrors.dateErr}
            </div>
          )}
        </div>
        <div>
          <input
            className="contactDetails"
            type="text"
            name="username"
            onChange={handleSubmit}
            placeholder="Enter Your Full Name"
          />
          {formErrors.usernameErr && (
            <div style={{ color: "red", paddingBottom: 10 }}>
              {formErrors.usernameErr}
            </div>
          )}
          <br />
          <input
            className="contactDetails"
            name="carName"
            type="text"
            placeholder="Enter Your Car Name"
            onChange={handleSubmit}
          />
          {formErrors.carNameErr && (
            <div style={{ color: "red", paddingBottom: 10 }}>
              {formErrors.carNameErr}
            </div>
          )}
          <br />

          <input
            className="contactDetails"
            type="text"
            name="carModel"
            placeholder="Vehicle Type"
            onChange={handleSubmit}
          />
          {formErrors.carModelErr && (
            <div style={{ color: "red", paddingBottom: 10 }}>
              {formErrors.carModelErr}
            </div>
          )}
          <br />
          {/* <input
                className="contactDetails"
                type="text"
                name="cost"
                onChange={handleSubmit}
                placeholder="Enter washpack cost"
              />
               {formErrors.costErr && (
                <div style={{ color: "red", paddingBottom: 10 }}>
                  {formErrors.costErr}
                </div>
              )}  */}
          <br />
          <input
            type="text"
            className="contactDetails"
            name="contactno"
            onChange={handleSubmit}
            placeholder="Enter Phone"
          />
          {formErrors.contactnoErr && (
            <div style={{ color: "red", paddingBottom: 10 }}>
              {formErrors.contactnoErr}
            </div>
          )}
          <br />

          <textarea
            cols="30"
            className="contactDetailsTextArea"
            rows="10"
            type="text"
            name="address"
            onChange={handleSubmit}
            placeholder="Your Address"
          />
          {formErrors.addressErr && (
            <div style={{ color: "red", paddingBottom: 10 }}>
              {formErrors.addressErr}
            </div>
          )}
        </div>
        <div>
          <button
            className="btn btn-outline-light btn-lg px-5"
            type="submit"
            onClick={() => {
              handleChange();
            }}
          >
            Submit
          </button>
        </div>
      </div>
    </div>
  );
}

export default Booking;
