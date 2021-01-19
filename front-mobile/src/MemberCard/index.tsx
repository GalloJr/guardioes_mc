import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { Member } from '../types';

type Props = {
    member: Member;
}

export default function MemberCard({ member}: Props) {
    return (
        <>
            <View style={styles.container}>
                <Text style={styles.memberName}>{member.name}</Text>
            </View>
        </>
    );
}

const styles = StyleSheet.create({
    container: {
        marginTop: '10%',
        marginLeft: '2%',
        marginRight: '2%',
        marginBottom: '2%',
        padding: 15,
        backgroundColor: '#FFF',
        shadowOpacity: 0.25,
        shadowColor: '#000',
        shadowOffset: { width: 0, height: 4 },
        shadowRadius: 20,
        borderRadius: 10,
        elevation: 5
      },
      memberName: {
        fontWeight: 'bold',
        fontSize: 18,
        lineHeight: 25,
        letterSpacing: -0.24,
        color: '#263238',
        fontFamily: 'OpenSans_700Bold',
        textAlign: 'center'
      }
});
