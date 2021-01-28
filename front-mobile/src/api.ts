import axios from "axios";

const API_URL = 'https://guardioes-mc.herokuapp.com'; 

export function fetchMembers() {
    return axios(`${API_URL}/members`);
}

export function fetchDirectors() {
    return axios(`${API_URL}/members/director`);
}

export function setAllright(memberId: number) {
    return axios.put(`${API_URL}/members/${memberId}/allright`)
}

export function setDelayed(memberId: number) {
    return axios.put(`${API_URL}/members/${memberId}/delayed`)
}