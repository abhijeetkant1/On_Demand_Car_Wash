import React, { useEffect, useState } from "react";
import axios from "axios";
import { useNavigate,useParams} from "react-router";
import { Link } from "react-router-dom";
import "./Washpack.css";
import { toast } from "react-toastify";
function UpdatePack() {
  const [pack, setPack] = useState({
    cost: "",
    packname: "",
    description: "",
  });
  const { id } = useParams();

  const navigate = useNavigate();
  const fetchPackById = () => {
    axios
      .get("http://localhost:8084/admin/viewPack/" + id)
      .then((resp) => setPack(resp.data));
  };
  useEffect(fetchPackById, []);
  const handleChange = (event) => {
    event.persist();
    setPack((pack) => ({ ...pack, [event.target.name]: event.target.value }));
  };
  const handleSubmit = () => {
    const palyload = {
      id: pack.id,
      packname: pack.packname,
      description: pack.description,
      cost: pack.cost,
    };
    axios
      .put("http://localhost:8084/admin/washpack/update", palyload)
      .then(function (response) {
        if (response && response.data) {
          toast.success(
            "Updated Washpack with Id "+pack.id,
            {
              position: "top-center",

              autoClose: 3000,
            }
          );
        }
        navigate("/admin_home");
      })
      .catch(function (error) {
        console.log(error);
      });
    };
  return (
    <div className='hero-containers'>
     <div className='in' >
        <div className='container' style={{width:"600px",float:"right",backgroundImage:"url(https://images.unsplash.com/photo-1553095066-5014bc7b7f2d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8d2FsbCUyMGJhY2tncm91bmR8ZW58MHx8MHx8&w=1000&q=80)"}}>
     
      <div>
        <h3>
          <h2 className='title' > Update Washpack</h2>
        </h3>
      </div>

      <h2 style={{ color: "green" }}>
        <u>Details</u>
      </h2>
      <div>
        <label style={{ color: "white" }}> ID:</label>
        <input
          type="text"
          className="form-control"
          placeholder=".form-control-sm"
          name="id"
          value={pack.id}
          onChange={handleChange}
          style={{ fontWeight: "700" }}
          disabled
        />
      </div>
      <div>
        <label style={{ color: "white" }}>PackName:</label>
        <input
          type="text"
          className="form-control"
          name="packname"
          value={pack.packname}
          onChange={handleChange}
          style={{ fontWeight: "700" }}
        />
      </div>

      <div>
        <label style={{ color: "white" }}>Description:</label>
        <input
          type="text"
          className="form-control"
          name="cdescription"
          value={pack.description}
          onChange={handleChange}
          style={{ fontWeight: "700" }}
        />
      </div>
      <div>
        <label style={{ color: "white" }}>Cost:</label>
        <input
          type="text"
          className="form-control"
          name="cost"
          value={pack.cost}
          onChange={handleChange}
          style={{ fontWeight: "700" }}
        />
      </div>

      <div>
        <button className="btn btn-primary mb-2" onClick={handleSubmit}>
          Update
        </button>
      </div>
    </div>
    </div>
</div>
  );
}
export default UpdatePack;