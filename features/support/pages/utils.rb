def save_member_database(content)
  File.open(MEMBER_DB, 'w') do |file|
    file.write(Psych.dump(content))
  end
end
