import { Ball, LinkedinIcon, Twitter } from '../../data/Icon';
import style from '../module/DevCard.module.css';
function DevCard({ data }) {
  const { name, id, description, role, image } = data;
  return (
    <>
      <div className={style.card}>
        <img src={image} />
        <div className={style.info}>
          <div>
            <h6>{name}</h6>
            <span>{role}</span>
            <p>{description}</p>
          </div>

          <div className={style.icons}>
            <Twitter />
            <LinkedinIcon />
            <Ball />
          </div>
        </div>
      </div>
    </>
  );
}

export default DevCard;
