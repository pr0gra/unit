import Image from "next/image";
import unitLogo from "./unit-logo-footer.svg";

export function Footer() {
  return (
    <footer className="">
      <Image className="" src={unitLogo} alt="" />
      <h1 className="">юнит</h1>
    </footer>
  );
}
