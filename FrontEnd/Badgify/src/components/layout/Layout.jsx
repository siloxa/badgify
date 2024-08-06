import Header from './Header';
import Footer from './Footer';
import { Outlet } from 'react-router-dom';
import styles from './layout.module.css';

function Layout({ children }) {
  return (
    <main className={styles.container}>
      <Header />
      <div className={styles.mainContainer}>
        <Outlet />
      </div>
      <Footer />
    </main>
  );
}

export default Layout;
