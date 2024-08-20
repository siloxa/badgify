import styles from '../module/BadgeCard.module.css'
import gitbadge from '../../assets/image/Frame578.jpg'
function BadgeCard({setModal}) {
  const editHandler = () => {
    setModal(true);
  }
  return (
    <>
    <div className={styles.card} >
        <img src={gitbadge} />
        <p>Githab badge</p>
        <button onClick={editHandler}>Edit</button>
    </div>
    </>
  )
}

export default BadgeCard
