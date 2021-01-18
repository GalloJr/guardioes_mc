import axios from "axios";

const API_URL = process.env.REACT_APP_API_URL;

export function fetchMembers() {
    return axios(`${API_URL}/members`);
}


