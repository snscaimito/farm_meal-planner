# set CLICK_DUMMY to true to fake backend
CLICK_DUMMY = true

BASE_URL = "http://#{ENV['HOST']}:#{ENV['PORT']}"
TMP_DIR = "#{Dir.pwd}/target/cucumber-tmp"
SCREENSHOTS_DIR = "#{TMP_DIR}/screenshots"

MEMBER_DB = "#{TMP_DIR}/members.yaml"

require 'watir'
require 'page-object'
require 'page-object/page_factory'
require 'rspec/expectations'
require 'fileutils'
require 'rest_client'
require 'json'

def is_port_open?(ip, port)
  begin
    Timeout::timeout(10) do
      begin
        s = TCPSocket.new(ip, port)
        s.close
        return true
      rescue Errno::ECONNREFUSED, Errno::EHOSTUNREACH
        return false
      end
    end
  rescue Timeout::Error
  end

  return false
end

count = 0
while is_port_open?(ENV['HOST'], ENV['PORT']) == false do
  # puts "trying to connect to #{ENV['HOST']}:#{ENV['PORT']}"
  count = count + 1
end


FileUtils.remove_dir TMP_DIR, true
FileUtils.mkdir_p TMP_DIR

FileUtils.remove_dir SCREENSHOTS_DIR, true
FileUtils.mkdir_p SCREENSHOTS_DIR

browser = Watir::Browser.new :chrome, {timeout: 120, url: "http://selenium:4444/wd/hub"}

Before do
  @browser = browser
  @browser.cookies.clear
end

at_exit do
  browser.close
end

World(PageObject::PageFactory)
