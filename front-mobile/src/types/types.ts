export type Member = {
    id: number;
    name: string;
    since: number;
    motorcycle: string;
    rank: string;
    sponsor: string;
    imageUri: string;
    status: number;
}

export type Event = {
    id: number;
    moment: string;
    description: string;
    address: string;
    status: string;
    members: Member;
}