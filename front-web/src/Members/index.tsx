import { useEffect, useState } from 'react';
import { fetchMembers } from '../api';
import MembersList from './MembersList';
import './styles.css';
import { Member } from './types';

function Members() {
    const [members, setMembers] = useState<Member[]>([]);

    useEffect(() => {
        fetchMembers()
        .then(response => setMembers(response.data))
        .catch(error => console.log(error))
    }, []);

    return (
        <div className="members-container">
            <MembersList members={members}/>
        </div>
    )
}

export default Members;