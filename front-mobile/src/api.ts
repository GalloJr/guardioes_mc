import axios from "axios";

const API_URL = 'https://guardioes-mc.herokuapp.com';

export function fetchMembers() {
    return axios(`${API_URL}/members`);
}

export function fetchEvents() {
    return axios(`${API_URL}/events`);
}

//criar essa rota no backend
export function fetchEventsByDate(eventDate: string) {
    return axios(`${API_URL}/events/${eventDate}/bydate`);
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

export function fetchNomad() {
    return axios(`${API_URL}/members/patent/rank?rank=Nomade`);
}

export function fetchMemorian() {
    return axios(`${API_URL}/members/patent/rank?rank=In%20Memorian`);
}