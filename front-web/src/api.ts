import axios from "axios";

const API_URL = 'https://guardioes-mc.herokuapp.com';

export function fetchMembers() {
    return axios(`${API_URL}/members`);
}