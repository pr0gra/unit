import Link from "next/link";
import Image from "next/image";

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
      <div className="max-w-7xl mx-auto mt-10">
        <div className="text-sm mb-2 ml-4">
          <Link className="text-gray-400" href="/p">
            Проекты /{" "}
          </Link>
          Сайт ПРОФКОМ
        </div>
        <div className="w-full h-[665px] bg-gray-300 rounded-2xl"></div>
        <div className="flex mt-10 gap-6 items-start">
          <div className="w-full rounded-2xl border border-gray-300 px-8 pb-20">
            <div className="my-20 text-4xl">Сайт ПРОФКОМ</div>
            <div>
              Профсоюзная организация студентов – это организация, призванная
              защищать законные права и интересы студентов. Проект был выполнен
              по заказу организации и по техническому заданию главного дизайнера
              и руководителя профсоюзной организации Уральского Экономического
              университета. Профсоюзная организация студентов – это организация,
              призванная защищать законные права и интересы студентов. Проект
              был выполнен по заказу организации и по техническому заданию
              главного дизайнера и руководителя профсоюзной организации
              Уральского Экономического университета.Профсоюзная организация
              студентов – это организация, призванная защищать законные права и
              интересы студентов. Проект был выполнен по заказу организации и по
              техническому заданию главного дизайнера и руководителя профсоюзной
              организации Уральского Экономического университета.
            </div>
          </div>
          <div className="w-[600px] rounded-2xl border border-gray-300">
            <div className="w-full h-[120px] bg-gray-300 rounded-t-2xl"></div>
            <div className="px-8">
              <div className="flex gap-3 justify-center my-8">
                <Image alt="" src="/vk.png" height={40} width={40} />
                <Image alt="" src="/tg.png" height={40} width={40} />
                <Image alt="" src="/yt.png" height={40} width={40} />
                <Image alt="" src="/be.png" height={40} width={40} />
              </div>
              <div className="text-lg">Интервью с командой</div>
              <div className="flex my-4 rounded-2xl border-gray-300 border px-6 items-center py-4 justify-between">
                <div className="text-sm">YouTube</div>
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  fill="none"
                  viewBox="0 0 24 24"
                  stroke-width="1.5"
                  stroke="currentColor"
                  className="w-4 h-4 stroke-gray-400"
                >
                  <path
                    stroke-linecap="round"
                    stroke-linejoin="round"
                    d="M4.5 19.5l15-15m0 0H8.25m11.25 0v11.25"
                  />
                </svg>
              </div>
              <div className="text-lg">Авторы проекта</div>
              <div className="flex gap-4 my-4 items-center">
                <div className="bg-gray-300 w-[50px] h-[50px] rounded-full"></div>
                <div>
                  <div className="text-sm">Григорий Маманов</div>
                  <div className="text-gray-400 text-xs mt-1">Программист</div>
                </div>
              </div>
              <div className="flex gap-4 my-4 items-center">
                <div className="bg-gray-300 w-[50px] h-[50px] rounded-full"></div>
                <div>
                  <div className="text-sm">Григорий Маманов</div>
                  <div className="text-gray-400 text-xs mt-1">Программист</div>
                </div>
              </div>
              <div className="flex gap-4 my-4 items-center">
                <div className="bg-gray-300 w-[50px] h-[50px] rounded-full"></div>
                <div>
                  <div className="text-sm">Григорий Маманов</div>
                  <div className="text-gray-400 text-xs mt-1">Программист</div>
                </div>
              </div>
              <div className="mb-8 text-xs text-gray-400 rounded-2xl border border-gray-300 py-2 text-center">Открыть полный список команды</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
