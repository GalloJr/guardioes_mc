import { useNavigation } from '@react-navigation/native';
import React from 'react';
import { Alert, Image, StyleSheet, Text, View } from 'react-native';
import { setAllright, setDelayed } from '../../api';
import { Button } from '../../Components/Button';
import Header from '../../Components/Header';
import { Member } from '../../types/types';

type Props = {
    route: {
        params: {
            member: Member;
        }
    }
}

export default function MemberDetails({ route }: Props) {
    const { member } = route.params;
    const navigation = useNavigation();

    const handleSetAllright = () => {
        setAllright(member.id)
            .then(() => {
                Alert.alert(`Integrante ${member.name} em dia!`);
                navigation.navigate('Members');
            })
            .catch(() => {
                Alert.alert(`Hoube um erro ao confirmar a atualização do ${member.name}`);
            })
    }

    const handleSetDelayed = () => {
        setDelayed(member.id)
            .then(() => {
                Alert.alert(`Integrante ${member.name} está com pendencia financeira!`);
                navigation.navigate('Members');
            })
            .catch(() => {
                Alert.alert(`Hoube um erro ao confirmar a atualização do ${member.name}`);
            })
    }

    return (
        <>
            <Header />
            <Image
                source={{ uri: member.imageUri }}
                style={styles.memberImage} />
            <View style={styles.container}>
                <View style={styles.header}>
                    <Text style={styles.memberName}>{member.name}</Text>
                    <Text style={styles.memberRank}>{member.rank}</Text>
                </View>
                <Text style={styles.text}>Membro desde {member.since}</Text>
                <Text style={styles.text}>Padrinho {member.sponsor}</Text>
                <Text style={styles.text}>Moto {member.motorcycle}</Text>
                <Text style={styles.text}>Financeiro {member.status}</Text>
            </View>
            <View style={styles.content}>
                <Button
                    title="FINANCEIRO EM DIA"
                    onPress={handleSetAllright}
                />
                <View style={styles.content}>
                    <Button
                        title="FINANCEIRO EM ATRASO"
                        onPress={handleSetDelayed}
                    />
                </View>
            </View>
        </>
    );
}

const styles = StyleSheet.create({
    content: {
        flex: 1,
        marginTop: '10%',
        width: '100%'
    },
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
    header: {
        flexDirection: 'row',
        justifyContent: 'space-between'
    },
    text: {
        fontWeight: 'normal',
        fontSize: 14,
        lineHeight: 19,
        letterSpacing: -0.24,
        color: '#9E9E9E',
        fontFamily: 'OpenSans_400Regular'
    },
    memberName: {
        fontWeight: 'bold',
        fontSize: 18,
        lineHeight: 25,
        letterSpacing: -0.24,
        color: '#263238',
        fontFamily: 'OpenSans_700Bold'
    },
    memberRank: {
        fontWeight: 'bold',
        fontSize: 18,
        lineHeight: 25,
        textAlign: 'right',
        letterSpacing: -0.24,
        color: '#FF0000',
        fontFamily: 'OpenSans_700Bold'
    },
    memberImage: {
        width: 400,
        height: 400,
        borderRadius: 50,
        marginTop: 15,
        marginLeft: '10%'
    }
}
);
