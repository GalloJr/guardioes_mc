import './styles.css';
import { ReactComponent as GitHubIcon } from './github.svg';
import { ReactComponent as LinkedinIcon } from './linkedin.svg';
import { ReactComponent as InstagramIcon } from './instagram.svg';

function Footer() {
    return (
        <footer className="main-footer">
            App desenvolvido por Gallo Jr. para o Guardiões M.C.
            <div className="footer-icons">
                <a href="https://github.com/GalloJr" target="_new">
                    <GitHubIcon />
                </a>
                <a href="https://www.linkedin.com/in/renatobgjunior/" target="_new">
                    <LinkedinIcon />
                </a>
                <a href="https://www.instagram.com/renatobgallojr" target="_new">
                    <InstagramIcon />
                </a>
            </div>
        </footer>
    )
}

export default Footer;