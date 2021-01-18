import './styles.css';
import { ReactComponent as MainImage } from './main.svg';
import { ReactComponent as MembersImage } from './members.svg';
import Footer from '../Footer';

function Home() {
    return (
        <>
            <div className="home-container">
                <div className="home-content">
                    <div className="home-actions">
                        <h1 className="home-title">
                            História do Guardiões M.C
                    </h1>
                        <h3 className="home-subtitle">
                            Moto Clube fundado em 1998, pelos amigos André e Lincon, o <br />
                         significado do brasão é que o cão cibernético é um guardião que <br />
                         olha e cuida de nossas motos. <br /> <br />
                         O Guardiões M. C. conta com uma filial em Santa Catarina e uma <br />
                         filial na Bahia alem da sede em São José dos Campos, a sede conta <br />
                         atualmente com 38 membros sendo 8 deles membros da diretoria <br />
                         e 3 membros Old Dogs que já são membros a mais de 15 anos.
                    </h3>
                        <div className="home-image">
                            <MembersImage />
                        </div>
                        <h5 className="home-address">
                            Sede <br /> R. Manoel Bôsco Ribeiro, 46 - Jardim das Industrias, São José dos Campos - SP, 12241-070
                    </h5>
                    </div>
                    <div className="home-image">
                        <MainImage />
                        <a href="members" className="home-btn-member">
                            INTEGRANTES
                    </a>
                    </div>
                </div>
            </div>
            <Footer />
        </>
    )
}

export default Home;