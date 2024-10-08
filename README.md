# StaticPlaceholders

The staticplaceholders plugin allows you to easily add static placeholders without having to implement static placeholders in other plugins.

If you need, you can add other placeholders to the permanent placeholders!

Config.yml:
```yaml
# Static placeholders. You can enter what placeholder you want on the left, and on the right the value it should convert to.
# You can also add other placeholders on the right side (where you convert to the new value) if 'parseNestedPlaceholders' is true.
staticPlaceholders:
  website: https://www.google.com
  website_message: '%static_website% is nice website!'

# If 'true', other placeholders (if any set) will be applied to the list of static placeholders.
parseNestedPlaceholders: true

# Message sent to player who does not have permission to reload staticplaceholders configs.
noPermissionMessage: '&cYou don''t have permissions to do that!'

# Message sent to a player who has successfully reloaded staticplaceholders configs.
successfullyReloadedMessage: '&aConfigs have been successfully reloaded!'
```
