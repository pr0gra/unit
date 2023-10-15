import Image from "next/image";
import styles from "./Header.module.css";

import logoHeader from "../../assets/icons/header-logo.svg";
import Link from "next/link";

export function Header() {
  return (
    <header className={styles["header"]}>
      <div className={styles["top-header"]}>
        <Image src={logoHeader} alt="logo"></Image>
        <Link className={styles["login-button"]} href={"/login"}>
          Войти
        </Link>
      </div>
      <nav className={styles["navigation"]}>
        <ul className={styles["navigation-array"]}>
          <li className={styles["navgigation-element"]}>
            <Link className={styles["link"]} href={"/"}>
              О нас
            </Link>{" "}
          </li>
          <li className={styles["navgigation-element"]}>
            <Link className={styles["link"]} href={"/"}>
              Проекты
            </Link>
          </li>
          <li className={styles["navgigation-element"]}>
            <Link className={styles["link"]} href={"/"}>
              Авторы
            </Link>
          </li>
        </ul>
      </nav>
    </header>
  );
}
