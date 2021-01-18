import MemberCard from "./MemberCard";
import { Member } from "./types";

type Props = {
    members: Member[];
}

function MembersList({ members }: Props) {
    return (
        <div className="members-list-container">
            <div className="members-list-items">
                {members.map(member => (
                    <MemberCard key={member.id} member={member}/>
                ))}
            </div>
        </div>
    )
}

export default MembersList;