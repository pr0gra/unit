import Image from "next/image";
import logoHeader from "./unit-logo-header.svg";
import Link from "next/link";

export function Header() {
  return (
    <header className="">
      <div className="">
        <Image src={logoHeader} alt=""></Image>
        <Link className="" href={"/login"}>
          Войти
        </Link>
      </div>
      <nav className="">
        <ul className="">
          <li className="">
            <Link className="" href="/">
              О нас
            </Link>{" "}
          </li>
          <li className="">
            <Link className="" href="/">
              Проекты
            </Link>
          </li>
          <li className="">
            <Link className="" href="/">
              Авторы
            </Link>
          </li>
        </ul>
      </nav>
    </header>
  );
}
