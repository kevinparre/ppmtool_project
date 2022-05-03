import axios from "axios";
import { GET_ERRORS } from "./types";
import { useNavigate } from 'react-router-dom';
import history from "../history";


export const createProject = (project) => async dispatch => {
  try {
    const response = await axios.post("http://localhost:8080/api/project", project);
    const navigate= useNavigate();
    navigate("/dashboard")
    history.push("/dashboard");
    
  } catch (err) {
    if(err.response){
    dispatch({
      type: GET_ERRORS,
      payload: err.response.data
    
    });
  }
}
  
};
 