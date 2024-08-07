import { FileIcon, PencilIcon, PuzzleIcon, RightArrow, ShieldIcon } from '../../data/Icon'
import styles from '../template/Home.module.css'


function Home() {
  return (
    <container className={styles.container}>
      <section className={styles.hero}>
      <div className={styles.heroBg}>
        <div className={styles.heroTextBox}>
          <h3><span>Badgify,</span>an easy-to-use API for generating custom badges</h3>
        <button className={styles.heroBtn}>CREATE BADGE <RightArrow/> </button>
        </div>
       
      </div>
      </section>
      <section className={styles.infoBox}>
      <div className={styles.info}>
          <div className={styles.infoPack}>
            <h2>150</h2>
            <h6>Generated Badge</h6>
          </div>
          <div className={styles.infoPack}>
            <h2>50</h2>
            <h6>Stars</h6>
          </div>
          <div className={styles.infoPack}>
            <h2>40</h2>
            <h6>Forks</h6>
          </div>
          <div className={styles.infoPack}>
            <h2>20</h2>
            <h6>Solved issues</h6>
          </div>
        </div>
      </section>
      <section className={styles.offerBox}>
      <h4>What Badgify offers you</h4>
        <div className={styles.offer}>
          
          <div className={styles.offerPack}>
            <PencilIcon />
            <h6>Making full customazable badges</h6>
          </div>
          <div className={styles.offerPack}>
            <ShieldIcon />
            <h6>Managing your personal badges</h6>
          </div>
          <div className={styles.offerPack}>
            <FileIcon />
            <h6>Monitoring how many times your badges have been seen</h6>
          </div>
          <div className={styles.offerPack}>
            <PuzzleIcon />
            <h6>Syncing with different social medias and platforms</h6>
          </div>
        </div>
     </section>
    </container>
    
  )
}

export default Home
