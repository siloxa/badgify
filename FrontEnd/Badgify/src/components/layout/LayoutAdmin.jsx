import Header from './Header';
import Footer from './Footer';
import { Outlet } from 'react-router-dom';
import styles from './layout.module.css';

function LayoutAdmin({ children }) {
  return (
    <main className={styles.container}>
      <Header />
      <div className={styles.mainContainer}>
        <Outlet />
      </div>
    </main>
  );
}

export default LayoutAdmin;
