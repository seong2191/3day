Token = '5408778538:AAGm1BDnEEuYkOYb9jGOlDjlb68p7CfAwjc'
from telegram.ext import Updater
from telegram.ext import CommandHandler, MessageHandler, Filters

updater = Updater(token=Token, use_context=True)

def fn_write_txt(text):
    f = open('../day2/diary.txt', 'a')
    f.write(text)
    f.writelines('\n')
    f.close()

def fn_echo(update, context):
    user_id = update.effective_chat.id
    user_text = update.message.text
    # 메세지온거 그대로 리턴
    # 메세지 저장
    print(user_text)
    fn_write_txt(user_text)

def fn_command_diary(update, context):
    user_id = update.effective_chat.id
    user_text = update.message.text
    print('다이어리다:',user_text)
    # 이 함수에서 특정 txt파일에 /dairy <-- 이외의 내용을 저장
    # ex) message:/diary 오늘은 회식이다
    # 오늘은 회식이다 <- 내용저장
    fn_write_txt(user_text)

echo_handler = MessageHandler(Filters.text & (~Filters.command), fn_echo)
updater.dispatcher.add_handler(echo_handler)

#다이어리 핸들러
diary_handler = CommandHandler('diary', fn_command_diary)
updater.dispatcher.add_handler(diary_handler)

updater.start_polling(timeout=5, clean=True)
updater.idle()