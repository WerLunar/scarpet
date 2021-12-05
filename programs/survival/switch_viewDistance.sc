// Switch carpet rule viewDistance with hard coded value
// For use in WerLunar's personal server, reject any pr with this one included. I tend to accidentally do pull requests somehow.

__config() -> (
   m(
      l('stay_loaded','true')
   )
);

__command() -> null;

0() -> ( run ('carpet viewDistance 0') );
