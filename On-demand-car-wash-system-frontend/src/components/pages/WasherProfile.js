import Footer from "./Footer";
import React, { useEffect, useState } from "react";
import axios from "axios";
// import { Link } from "react-router-dom";
import "./login.css";
// import "../pages/Style.css";
import AdminNab from "./AdminNab";
import { Row } from "react-bootstrap";

export default function WasherProfile() {
  const [washer, setWasher] = useState([]);

  const fetchAll = () => {
    axios
      .get("http://localhost:8087/admin/allwasher")
      .then((resp) => setWasher(resp.data));
  };
  useEffect(fetchAll, []);

  return (
    <div style={{backgroundImage: "url(https://www.octalsoftware.com/blog/wp-content/uploads/2021/09/zWOebGj2YW3UgBLQpfSileHZ2uZ8ZPOIY0mRDWWZ.png)", height: "90vh",backgroundSize:"cover",backgroundRepeat:"no-repeat",width:"50"}}>
    <div>
    <div className="row body">
      <AdminNab />
      <div className=" wbg col-md-6" >
       
      </div>
     

      
      <div className="col-md-6">
        <h4
          style={{
            color: "white",
            backgroundColor: "black",
            fontSize: "30px",
          }}
          className="text-center "
        >
          WASHER LIST
        </h4>
        <Row xs={1} md={2} className="g-4 ">
          <table class="table table-bordered ">
            <thead
              class="black white-text"
              style={{ backgroundColor: "black" ,color:"white"}}
            >
              <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Location</th>
                {/* <th colSpan={2}>Actions</th> */}
              </tr>
            </thead>

            <tbody>
              {washer.map((w, index) => (
                <tr key={index + 1}>
                  {/* <td>{index+1}</td> */}
                  <td>{w.id}</td>
                  <td>{w.name}</td>
                  <td>{w.location}</td>
                  
                </tr>
              ))}
            </tbody>
          </table>
        </Row>
      </div>
    </div>
    </div>
    <div>
    <Footer />
    </div>
    </div>
  );
}