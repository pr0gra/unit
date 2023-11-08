import Link from "next/link";

export default function Project({ params }: { params: any }) {
  return (
    <div className="pb-20">
      <div className="text-4xl py-8 flex justify-center">юнит</div>
      <div className="flex justify-center text-sm space-x-8">
        <Link className="px-6 py-1" href="/">
          О нас
        </Link>
        <Link className="px-6 py-1" href="/">
          Проекты
        </Link>
        <Link className="px-6 py-1" href="/">
          Авторы
        </Link>
      </div>
      <div className="text-center mt-20">Тут будет проект</div>
    </div>
  );
}
