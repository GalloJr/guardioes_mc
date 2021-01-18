import { Member } from './types';

type Props = {
    member: Member;
}

function MemberCard({ member }: Props) {
    return (
        <div className="member-card-container">
            <h3 className="member-card-title">
                {member.name}
            </h3>
            <img src={member.imageUri} className="member-card-image" alt={member.name}/>
            <h3 className="member-card-rank">
                {member.rank}
            </h3>
            <div className="member-card-description">
                <h3> Padrinho {member.sponsor} </h3>
                <p>
                Membro desde {member.since} <br />Moto {member.motorcycle}
                </p>
            </div>
        </div>
    )
}

export default MemberCard;