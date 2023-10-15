import Image from "next/image";
import styles from "./page.module.css";
import Link from "next/link";

export default function Home() {
  return (
    <main className={styles["main"]}>
      <div className={styles["hero"]}>
        <div className={styles["text-part"]}>
          <h2 className={styles["title"]}>создаём реальные проекты</h2>
          <h3 className={styles["subtitle"]}>
            Мы делаем приложения <br /> игры и сайты
          </h3>
        </div>
        <div className={styles["more-info"]}>
          <div className={styles["more-info-text-container"]}>
            <p className={styles["more-info-text"]}>
              ЮНИТ - это студенческое IT объединение в Екатеринбурге, которое
              базируется на базе экономического университета (УРГЭУ)
            </p>
          </div>
        </div>
      </div>
      <div className={styles["about-part"]}>
        <div className={styles["about-us"]}>
          <p className={styles["about-us-title"]}>
            Навыки, которые мы прокачиваем каждый день:{" "}
          </p>
          <nav className={styles["about-array-container"]}>
            <ul className={styles["about-array"]}>
              <li className={styles["about-element"]}>
                <p>Дизайн</p>
              </li>
              <li className={styles["about-element"]}>
                <p>Программирование</p>
              </li>
              <li className={styles["about-element"]}>
                <p>3D-моделирование</p>
              </li>
              <li className={styles["about-element"]}>
                <p>Медиа</p>
              </li>
            </ul>
          </nav>
        </div>
        <div className={styles["about-us"]}>
          <p className={styles["about-us-title"]}>
            Мероприятия, которые мы проводим:
          </p>
          <nav className={styles["about-array-container"]}>
            <ul className={styles["about-array"]}>
              <li className={styles["about-element"]}>
                <p>Собственные лекции</p>
              </li>
              <li className={styles["about-element"]}>
                <p>Лекции от известных IT-компаний</p>
              </li>
              <li className={styles["about-element"]}>
                <p>Хакатоны</p>
              </li>
            </ul>
          </nav>
        </div>
        <div className={styles["join-us-part"]}>
          <p className={styles["join-us-text"]}>
            Мы верим, что уже будучи студентом можно создавать проекты, меняющие
            жизнь людей
          </p>

          <Link
            className={styles["join-us-button"]}
            href={"https://vk.com/unit.usue"}
          >
            Стать частью команды
          </Link>
        </div>
      </div>
    </main>
  );
}
